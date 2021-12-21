package com.lyuwalle.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.service.HrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lyuxiyang
 */
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HrService hrService;

    /**
     * 自定义的权限拦截管理器
     */
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    /**
     * 自定义的决策管理器
     */
    @Autowired
    private CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    /**
     * 下面的url不经过security拦截
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**",
                "/index.html",
                "/img/**",
                "/fonts/**",
                "/favicon.ico",
                "/verifyCode",
                "/login"
                );
    }

    /**
     * 处理登录成功和登录失败
     *
     * @param http
     * @throws Exception
     *
     * 登录页面：/login
     * 登录处理页面（后端登录接口）：/doLogin
     * 注销url：/logout
     * permitAll() ： 不认证权限就允许访问
     * and() ： 将方法连接在一起
     * csrf().disable() ： 禁用csrf攻击防御
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
/*                .anyRequest().authenticated()*/
                /*使用自己定义的权限管理*/
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    Hr principal = (Hr) authentication.getPrincipal();
                    principal.setPassword(null);
                    RespBean ok = RespBean.ok("登录成功！", principal);
                    log.info("用户<{}>登录成功" , principal.getName());
                    //登录成功把用户对象返回出去
                    String s = new ObjectMapper().writeValueAsString(ok);
                    writer.write(s);
                    writer.flush();
                    writer.close();
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    RespBean respBean = RespBean.error("登录失败！");
                    if (exception instanceof LockedException) {
                        respBean.setMessage("账户被锁定，请联系管理员!");
                    } else if (exception instanceof CredentialsExpiredException) {
                        respBean.setMessage("密码过期，请联系管理员!");
                    } else if (exception instanceof AccountExpiredException) {
                        respBean.setMessage("账户过期，请联系管理员!");
                    } else if (exception instanceof DisabledException) {
                        respBean.setMessage("账户被禁用，请联系管理员!");
                    } else if (exception instanceof BadCredentialsException) {
                        respBean.setMessage("用户名或者密码输入错误，请重新输入!");
                    }
                    String s = new ObjectMapper().writeValueAsString(respBean);
                    writer.write(s);
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    RespBean respBean = RespBean.ok("注销成功！");
                    String logoutMessage = new ObjectMapper().writeValueAsString(respBean);
                    writer.write(logoutMessage);
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .csrf().disable()
                /*没有登录时，在这里处理结果，不需要重定向。那前面的.loginPage("/login")就不再需要，LoginController里面的 /login 也不需要
                前端重定向的结果就是localhost:8080/login，而不经过nodejs*/
                /*这是一个跨域的问题，解决办法就是直接提示重新登录*/

                /*在路由导航守卫已经解决了没有登录直接访问的问题，那下面这个还需要吗(postman直接访问的时候会显示下面的msg)*/
                /*需要的。路由导航守卫解决的是window.sessionStorage里面没有user的缓存信息，则直接去登录页面*/
                /*当后端重启时，前端尚有user缓存，不注销登录的前提下如果再去访问一个页面，就会提示下面的信息*/
                .exceptionHandling().authenticationEntryPoint((request, response, e) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(401);
                    PrintWriter out = response.getWriter();
                    RespBean error = RespBean.error("^_^");
                    if(e instanceof InsufficientAuthenticationException){
                        /*那么下面这句话前端就看不到了，前端如果发现是401就会replace到登录页面，这句话只有在用postman测试时才会看到*/
                        error.setMessage("权限不足，请登录后访问");
                    }
                    out.write(new ObjectMapper().writeValueAsString(error));
                    out.flush();
                    out.close();
                });
    }
}
