package com.lyuwalle.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HrService hrService;

    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
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
                "/verifyCode");
    }

    /**
     * 处理登录成功和登录失败
     *
     * @param http
     * @throws Exception
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
                .csrf().disable();
    }
}
