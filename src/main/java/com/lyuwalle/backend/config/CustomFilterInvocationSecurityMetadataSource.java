package com.lyuwalle.backend.config;

import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author: Lyuwalle  @date: 2021/12/08 23:34
 *
 * 自定义权限拦截管理器
 *
 * 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色,在getAttributes方法中返回的是一个角色数组。
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    /**
     * 类AntPathMatcher主要用来做类URLs字符串匹配
     */
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 表示这个url需要哪些角色才能访问
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //Menu类里面有一个List<Role>属性
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleNames = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleNames[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);
            }
        }
        //只是一个标记，下一步如果遇到这个，那么就让他重新登录
        //具体是在CustomUrlDecisionManager里面的decide中判断
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
