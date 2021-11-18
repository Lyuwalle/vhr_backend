package com.lyuwalle.backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MailSendLog {

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

}
