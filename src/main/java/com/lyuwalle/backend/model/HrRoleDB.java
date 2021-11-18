package com.lyuwalle.backend.model;

import javax.persistence.*;

@Table(name = "hr_role")
public class HrRoleDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer hrId;

    private Integer rid;

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
     * @return hrId
     */
    public Integer getHrId() {
        return hrId;
    }

    /**
     * @param hrId
     */
    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    /**
     * @return rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }
}