package com.lyuwalle.backend.domain;

import lombok.Data;

/**
 * @author: Lyuwalle  @date: 2021/11/29 23:33
 * 把menu里面的两个属性提取出来
 */
@Data
public class Meta {

    private Boolean keepAlive;

    private Boolean requireAuth;
}
