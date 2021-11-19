package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "adjust_salary")
public class AdjustSalaryDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer eid;

    /**
     * 调薪日期
     */
    @Column(name = "as_date")
    private Date asDate;

    /**
     * 调后薪资
     */
    @Column(name = "before_salary")
    private Integer beforeSalary;

    /**
     * 调后薪资
     */
    @Column(name = "after_salary")
    private Integer afterSalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
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
     * 获取调薪日期
     *
     * @return as_date - 调薪日期
     */
    public Date getAsDate() {
        return asDate;
    }

    /**
     * 设置调薪日期
     *
     * @param asDate 调薪日期
     */
    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    /**
     * 获取调后薪资
     *
     * @return before_salary - 调后薪资
     */
    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    /**
     * 设置调后薪资
     *
     * @param beforeSalary 调后薪资
     */
    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    /**
     * 获取调后薪资
     *
     * @return after_salary - 调后薪资
     */
    public Integer getAfterSalary() {
        return afterSalary;
    }

    /**
     * 设置调后薪资
     *
     * @param afterSalary 调后薪资
     */
    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }

    /**
     * 获取调薪原因
     *
     * @return reason - 调薪原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置调薪原因
     *
     * @param reason 调薪原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}