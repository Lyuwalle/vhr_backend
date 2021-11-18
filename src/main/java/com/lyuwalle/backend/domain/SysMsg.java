package com.lyuwalle.backend.domain;

import lombok.Data;

@Data
public class SysMsg {

    private Integer id;

    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 0表示群发消息
     */
    private Integer type;

    /**
     * 这条消息是给谁的
     */
    private Integer hrId;

    /**
     * 0 未读 1 已读
     */
    private Integer state;
}
