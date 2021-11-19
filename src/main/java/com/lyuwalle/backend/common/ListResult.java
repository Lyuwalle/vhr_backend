package com.lyuwalle.backend.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个返回分页结果的处理类
 *
 * @author lyuxiyang
 */
public class ListResult<T> {

    private long total;
    private List<T> records = new ArrayList<>();

    public ListResult(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
