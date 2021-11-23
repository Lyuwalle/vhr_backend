package com.lyuwalle.backend.utils;

import com.lyuwalle.backend.domain.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author lyuxiyang
 * 得到当前登录的用户
 */
public class HrUtil {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
