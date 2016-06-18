package com.kaishengit.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class Page<T> {

    private Integer pageSize;
    private Integer totalCount;
    private Integer pageNo;
    private Integer totalPageSize;
    private Integer start;
    private List<T> items;
    private Logger logger = LoggerFactory.getLogger(Page.class);
    public Page(Integer totalCount, Integer pageSize, Integer pageNo) {

        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;

        totalPageSize = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            totalPageSize++;
        }

        if (pageNo > totalPageSize) {
            this.pageNo = totalPageSize;
        }
        if (pageNo <= 0) {
            this.pageNo = 1;
        }
        logger.debug("{}",pageNo);
        start = (this.pageNo-1) * pageSize;

    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getTotalPageSize() {
        return totalPageSize;
    }

    public Integer getStart() {
        return start;
    }

    public List<T> getItems() {
        return items;
    }
}
