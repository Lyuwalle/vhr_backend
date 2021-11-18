package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AdjustSalary {

    private Integer id;

    private Integer eid;

    /**
     * 调薪日期
     */
    private Date asDate;

    /**
     * 调前薪资
     */
    private Integer beforeSalary;

    /**
     * 调后薪资
     */
    private Integer afterSalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;
}
