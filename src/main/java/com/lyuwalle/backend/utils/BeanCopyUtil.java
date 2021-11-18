package com.lyuwalle.backend.utils;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 类的属性复制工具
 * 要求类型和名称一模一样
 */
@Slf4j
public class BeanCopyUtil {

    /**
     * 数据复制
     *
     * @param source
     * @param target
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> K copy(T source, Class<K> target) {
        if (Objects.isNull(source)) {
            return null;
        }
        K targetInstance = null;
        try {
            targetInstance = target.newInstance();
            BeanUtils.copyProperties(source, targetInstance);
        } catch (Exception ex) {
            log.error("数据copy异常" + ex.getMessage());
        }
        return targetInstance;
    }


    public static <T, K> List<K> copy(List<T> sourceList, Class<K> target) {
        List<K> targetList = new ArrayList();
        if (CollectionUtil.isNotEmpty(sourceList)) {
            sourceList.stream().forEach(source -> {
                K k = copy(source, target);
                if (Objects.nonNull(k)) {
                    targetList.add(k);
                }
            });
        }
        return targetList;
    }
}
