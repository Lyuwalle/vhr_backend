package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee_ec")
public class EmployeeEcDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工编号
     */
    private Integer eid;

    /**
     * 奖罚日期
     */
    @Column(name = "ec_date")
    private Date ecDate;

    /**
     * 奖罚原因
     */
    @Column(name = "ec_reason")
    private String ecReason;

    /**
     * 奖罚分
     */
    @Column(name = "ec_point")
    private Integer ecPoint;

    /**
     * 奖罚类别，0：奖，1：罚
     */
    @Column(name = "ec_type")
    private Integer ecType;

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
     * 获取员工编号
     *
     * @return eid - 员工编号
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置员工编号
     *
     * @param eid 员工编号
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取奖罚日期
     *
     * @return ec_date - 奖罚日期
     */
    public Date getEcDate() {
        return ecDate;
    }

    /**
     * 设置奖罚日期
     *
     * @param ecDate 奖罚日期
     */
    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    /**
     * 获取奖罚原因
     *
     * @return ec_reason - 奖罚原因
     */
    public String getEcReason() {
        return ecReason;
    }

    /**
     * 设置奖罚原因
     *
     * @param ecReason 奖罚原因
     */
    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    /**
     * 获取奖罚分
     *
     * @return ec_point - 奖罚分
     */
    public Integer getEcPoint() {
        return ecPoint;
    }

    /**
     * 设置奖罚分
     *
     * @param ecPoint 奖罚分
     */
    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }

    /**
     * 获取奖罚类别，0：奖，1：罚
     *
     * @return ec_type - 奖罚类别，0：奖，1：罚
     */
    public Integer getEcType() {
        return ecType;
    }

    /**
     * 设置奖罚类别，0：奖，1：罚
     *
     * @param ecType 奖罚类别，0：奖，1：罚
     */
    public void setEcType(Integer ecType) {
        this.ecType = ecType;
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