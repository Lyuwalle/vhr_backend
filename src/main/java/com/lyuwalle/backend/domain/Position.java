package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Position {

    private Integer id;

    /**
     * 职位
     */
    private String name;

    private Date createDate;

    private Boolean enabled;
}
