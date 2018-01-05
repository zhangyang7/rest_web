package com.pbody.rest_web.dao.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Pbody
 * @create 2018-01-05 15:58
 * @description： 基类Bean
 */
public class BaseBean {

    @JsonIgnore
    private int pageNum=1;       //从第几页开始

    @JsonIgnore
    private int pageSize=5;      //每页显示多少

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}