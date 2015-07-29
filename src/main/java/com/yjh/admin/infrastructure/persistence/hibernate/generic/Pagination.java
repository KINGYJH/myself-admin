package com.yjh.admin.infrastructure.persistence.hibernate.generic;

import java.util.List;

/**
 * Created by yjh on 2015/7/29.
 */
public class Pagination<T> {
    private List<T> data;
    private int count;
    private int page;
    private int pageSize;

    public Pagination(List<T> data, int count, int page, int pageSize) {
        this.data = data;
        this.count = count;
        this.page = page;
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }
}
