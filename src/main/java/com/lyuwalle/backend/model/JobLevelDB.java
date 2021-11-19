package com.lyuwalle.backend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "job_level")
public class JobLevelDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    @Column(name = "title_level")
    private String titleLevel;

    @Column(name = "create_date")
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
     * 获取职称名称
     *
     * @return name - 职称名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职称名称
     *
     * @param name 职称名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return title_level
     */
    public String getTitleLevel() {
        return titleLevel;
    }

    /**
     * @param titleLevel
     */
    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    /**
     * @return create_date
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