package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Meta meta;

    private Integer parentId;

    private Boolean enabled;

    /**
     * 子菜单
     */
    private List<Menu> children;
}
