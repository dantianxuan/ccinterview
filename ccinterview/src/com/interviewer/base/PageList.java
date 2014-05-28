/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.interviewer.base;

import java.util.List;

/**
 * 
 * @author danjingyu
 * @version $Id: PageList.java, v 0.1 2014-3-16 下午12:04:06 danjingyu Exp $
 */
public class PageList<T> extends ToString {

    /**  */
    private static final long serialVersionUID = 1L;

    private int     total;

    private List<T> list;

    private int     pageSize;

    private int     currentPage;

    /**
     * 构造函数
     * 
     * @param pageSize
     * @param total
     * @param currentPage
     * @param list
     */
    public PageList(int pageSize, int total, int currentPage, List<T> list) {
        this.pageSize = pageSize;
        this.total = total;
        this.currentPage = currentPage;
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
