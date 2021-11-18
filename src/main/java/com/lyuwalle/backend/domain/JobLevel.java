package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class JobLevel {

    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    private String titleLevel;

    private Date createDate;

    private Boolean enabled;
}
