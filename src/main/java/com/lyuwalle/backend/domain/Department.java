package com.lyuwalle.backend.domain;

import lombok.Data;

@Data
public class Department {

    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    private Integer parentId;

    private String depPath;

    private Boolean enabled;

    private Boolean isParent;
}
