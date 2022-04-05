package com.lyuwalle.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;
}
