package com.lyuwalle.backend.common;

import lombok.Getter;

/**
 * @author lyuxiyang
 * 一个处理响应的实体类,config/SecurityConfig中处理登录成功失败
 */
public class RespBean {

    @Getter
    private Integer status;

    @Getter
    private String message;

    @Getter
    private Object object;

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok(String message) {
        return new RespBean(200, message, null);
    }

    public static RespBean ok(String message, Object o) {
        return new RespBean(200, message, o);
    }
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }
    public static RespBean error(String message, Object o) {
        return new RespBean(500, message, o);
    }




    /**
     * 构造器全部私有化
     */
    private RespBean() {}

    private RespBean(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public RespBean setMessage(String msg) {
        this.message = msg;
        return this;
    }
    public RespBean setObject(Object o) {
        this.object = o;
        return this;
    }

}
