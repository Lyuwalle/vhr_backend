package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeTrain {

    private Integer id;

    /**
     * 员工编号
     */
    private Integer eid;

    /**
     * 培训日期
     */
    private Date trainDate;

    /**
     * 培训内容
     */
    private String trainContent;

    /**
     * 备注
     */
    private String remark;
}
