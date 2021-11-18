package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "oplog")
public class OplogDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 获取添加日期
     *
     * @return addDate - 添加日期
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * 设置添加日期
     *
     * @param addDate 添加日期
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * 获取操作内容
     *
     * @return operate - 操作内容
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 设置操作内容
     *
     * @param operate 操作内容
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }

    /**
     * 获取操作员ID
     *
     * @return hrId - 操作员ID
     */
    public Integer getHrId() {
        return hrId;
    }

    /**
     * 设置操作员ID
     *
     * @param hrId 操作员ID
     */
    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }
}