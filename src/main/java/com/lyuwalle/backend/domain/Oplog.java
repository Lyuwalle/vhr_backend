package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Oplog {

    private Integer id;

    /**
     * 添加日期
     */
    private Date addDate;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    private Integer hrId;
}
