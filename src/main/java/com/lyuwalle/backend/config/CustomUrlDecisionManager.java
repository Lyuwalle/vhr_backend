package com.lyuwalle.backend.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author: Lyuwalle  @date: 2021/12/14 00:02
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    /**
     * 判断当前用户是否具备CustomFilterInvocationSecurityMetadataSource分析出来的角色
     * 判断当前请求具有的权限和当前请求需要的权限的关系。
     *
     * @param authentication
     * @param o
     * @param collection
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : collection) {
            String needRole = configAttribute.getAttribute();
            /**
             * 前端页面已经做了限制，如果没有登录访问一个url，如果window.sessionStorage里面没有这个user，路由导航守卫会定向到登录页面
             * 然后登录之后重定向到之前想要的访问地址
             * 因此下面这个if不会执行，页面不会提示让用户登录。
             */
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录");
                } else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
