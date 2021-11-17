package com.lyuwalle.backend.domain;

import lombok.Data;

@Data
public class Role {

    private Integer id;

    private String name;
    /**
     * 角色名称
     */
    private String nameZh;
}
