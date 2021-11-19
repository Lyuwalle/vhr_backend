package com.lyuwalle.backend.model;

import javax.persistence.*;

@Table(name = "hr_role")
public class HrRoleDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer hrid;

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
     * @return hrid
     */
    public Integer getHrid() {
        return hrid;
    }

    /**
     * @param hrid
     */
    public void setHrid(Integer hrid) {
        this.hrid = hrid;
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