package com.lyuwalle.backend.model;

import javax.persistence.*;

@Table(name = "role")
public class RoleDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    @Column(name = "name_zh")
    private String nameZh;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色名称
     *
     * @return name_zh - 角色名称
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * 设置角色名称
     *
     * @param nameZh 角色名称
     */
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}