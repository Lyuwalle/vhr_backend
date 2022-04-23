package com.lyuwalle.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyuwalle.backend.common.RespBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: Lyuwalle  @date: 2022/04/24 00:31
 * 验证码过滤器
 */
@Component
public class VerificationCodeFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if("POST".equals(req.getMethod()) && "/doLogin".equals(req.getServletPath())){
            //这是一个登录请求
            String code = req.getParameter("code");
            //req.getSession()，从session里面拿到验证码图片所对应的真实的验证码，这一个动作在LoginController里面发生
            String realVerifyCode = (String) req.getSession().getAttribute("verify_code");
            if(code == null || code == "" || !code.equalsIgnoreCase(realVerifyCode)){
                //验证码不正确
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                RespBean error = RespBean.error("验证码不正确！");
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
                return;
            } else {
                //验证码没有问题那么过滤器继续向下走
                filterChain.doFilter(req,resp);
            }
        }else{
            /*其他的请求放行*/
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
