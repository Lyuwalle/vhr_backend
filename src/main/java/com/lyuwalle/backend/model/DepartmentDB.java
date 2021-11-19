package com.lyuwalle.backend.model;

import javax.persistence.*;

@Table(name = "department")
public class DepartmentDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "dep_path")
    private String depPath;

    private Boolean enabled;

    @Column(name = "is_parent")
    private Boolean isParent;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return dep_path
     */
    public String getDepPath() {
        return depPath;
    }

    /**
     * @param depPath
     */
    public void setDepPath(String depPath) {
        this.depPath = depPath;
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

    /**
     * @return is_parent
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * @param isParent
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }
}