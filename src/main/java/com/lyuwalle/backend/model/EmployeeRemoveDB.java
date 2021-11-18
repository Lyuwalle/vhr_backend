package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee_remove")
public class EmployeeRemoveDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return eid
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * @param eid
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取调动后部门
     *
     * @return afterDepId - 调动后部门
     */
    public Integer getAfterDepId() {
        return afterDepId;
    }

    /**
     * 设置调动后部门
     *
     * @param afterDepId 调动后部门
     */
    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }

    /**
     * 获取调动后职位
     *
     * @return afterJobId - 调动后职位
     */
    public Integer getAfterJobId() {
        return afterJobId;
    }

    /**
     * 设置调动后职位
     *
     * @param afterJobId 调动后职位
     */
    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }

    /**
     * 获取调动日期
     *
     * @return removeDate - 调动日期
     */
    public Date getRemoveDate() {
        return removeDate;
    }

    /**
     * 设置调动日期
     *
     * @param removeDate 调动日期
     */
    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    /**
     * 获取调动原因
     *
     * @return reason - 调动原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置调动原因
     *
     * @param reason 调动原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}