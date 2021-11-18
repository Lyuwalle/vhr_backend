package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mail_send_log")
public class MailSendLogDB {
    private String msgId;

    private Integer empId;

    /**
     * 0发送中，1发送成功，2发送失败
     */
    private Integer status;

    private String routeKey;

    private String exchange;

    /**
     * 重试次数
     */
    private Integer count;

    /**
     * 第一次重试时间
     */
    private Date tryTime;

    private Date createTime;

    private Date updateTime;

    /**
     * @return msgId
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * @param msgId
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取0发送中，1发送成功，2发送失败
     *
     * @return status - 0发送中，1发送成功，2发送失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0发送中，1发送成功，2发送失败
     *
     * @param status 0发送中，1发送成功，2发送失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return routeKey
     */
    public String getRouteKey() {
        return routeKey;
    }

    /**
     * @param routeKey
     */
    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    /**
     * @return exchange
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * @param exchange
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取重试次数
     *
     * @return count - 重试次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置重试次数
     *
     * @param count 重试次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取第一次重试时间
     *
     * @return tryTime - 第一次重试时间
     */
    public Date getTryTime() {
        return tryTime;
    }

    /**
     * 设置第一次重试时间
     *
     * @param tryTime 第一次重试时间
     */
    public void setTryTime(Date tryTime) {
        this.tryTime = tryTime;
    }

    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}