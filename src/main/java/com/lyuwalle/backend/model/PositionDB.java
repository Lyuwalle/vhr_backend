package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "position")
public class PositionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 职位
     */
    private String name;

    private Date createDate;

    private Boolean enabled;

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
     * 获取职位
     *
     * @return name - 职位
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职位
     *
     * @param name 职位
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}