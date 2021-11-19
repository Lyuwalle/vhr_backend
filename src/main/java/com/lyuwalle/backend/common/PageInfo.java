package com.lyuwalle.backend.common;

/**
 * @author lyuxiyang
 */
public class PageInfo {

    private Integer page;
    private Integer pageSize;

    public PageInfo() {
        this.page = 1;
        this.pageSize = 10;
    }

    public PageInfo(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
