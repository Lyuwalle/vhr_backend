package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Appraise {

    private Integer id;

    private Integer eid;

    /**
     * 考评日期
     */
    private Date appDate;

    /**
     * 考评结果
     */
    private String appResult;

    /**
     * 考评内容
     */
    private String appContent;

    /**
     * 备注
     */
    private String remark;

}
