package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "appraise")
public class AppraiseDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 获取考评日期
     *
     * @return appDate - 考评日期
     */
    public Date getAppDate() {
        return appDate;
    }

    /**
     * 设置考评日期
     *
     * @param appDate 考评日期
     */
    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    /**
     * 获取考评结果
     *
     * @return appResult - 考评结果
     */
    public String getAppResult() {
        return appResult;
    }

    /**
     * 设置考评结果
     *
     * @param appResult 考评结果
     */
    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    /**
     * 获取考评内容
     *
     * @return appContent - 考评内容
     */
    public String getAppContent() {
        return appContent;
    }

    /**
     * 设置考评内容
     *
     * @param appContent 考评内容
     */
    public void setAppContent(String appContent) {
        this.appContent = appContent;
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