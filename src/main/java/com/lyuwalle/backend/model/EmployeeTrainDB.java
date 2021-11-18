package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee_train")
public class EmployeeTrainDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 获取培训日期
     *
     * @return trainDate - 培训日期
     */
    public Date getTrainDate() {
        return trainDate;
    }

    /**
     * 设置培训日期
     *
     * @param trainDate 培训日期
     */
    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    /**
     * 获取培训内容
     *
     * @return trainContent - 培训内容
     */
    public String getTrainContent() {
        return trainContent;
    }

    /**
     * 设置培训内容
     *
     * @param trainContent 培训内容
     */
    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
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