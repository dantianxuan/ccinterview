/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.query;

import com.interviewer.base.CcResult;

/**
 * 公司查询服务
 * 
 * @author jingyu.dan
 * @version $Id: QueryCompanyService.java, v 0.1 2014-5-28 下午7:58:28 jingyu.dan Exp $
 */
public interface QueryCompanyService {

    /***
     * 查询所有的公司
     * 
     * @return
     */
    public CcResult queryAllCompany();

    /***
     * 查询所有的公司
     *  最大limit100
     * @return
     */
    public CcResult searchFuzzyByName(String name);
    
    /***
     * 查询所有的公司
     *  最大limit100
     * @return
     */
    public CcResult queryCompanyByCatagoryId(int categoryId);

}
