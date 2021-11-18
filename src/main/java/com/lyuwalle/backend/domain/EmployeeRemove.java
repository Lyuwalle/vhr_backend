package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRemove {

    private Integer id;

    private Integer eid;

    /**
     * 调动后部门
     */
    private Integer afterDepId;

    /**
     * 调动后职位
     */
    private Integer afterJobId;

    /**
     * 调动日期
     */
    private Date removeDate;

    /**
     * 调动原因
     */
    private String reason;

    private String remark;
}
