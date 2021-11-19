package com.lyuwalle.backend.model;

import javax.persistence.*;

@Table(name = "menu")
public class MenuDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    @Column(name = "icon_cls")
    private String iconCls;

    @Column(name = "keep_alive")
    private Boolean keepAlive;

    @Column(name = "require_auth")
    private Boolean requireAuth;

    @Column(name = "parent_id")
    private Integer parentId;

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component;
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
     * @return icon_cls
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * @param iconCls
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * @return keep_alive
     */
    public Boolean getKeepAlive() {
        return keepAlive;
    }

    /**
     * @param keepAlive
     */
    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    /**
     * @return require_auth
     */
    public Boolean getRequireAuth() {
        return requireAuth;
    }

    /**
     * @param requireAuth
     */
    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
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