/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.query;

import com.interviewer.base.CcResult;

/**
 * 查询服务
 * 
 * @author jingyu.dan
 * @version $Id: QueryJobSeekerService.java, v 0.1 2014-5-28 下午7:59:01 jingyu.dan Exp $
 */
public interface QueryUserInfoService {

    /***
     * 查询所有的用户
     * 
     * @return
     */
    public CcResult queryAllUserInfo();

    /***
     * 通过id查询用户
     * 
     * @return
     */
    public CcResult queryUserInfoById(int id);

    /***
     * 通过id查询用户
     * 
     * @return
     */
    public CcResult queryUserInfoByCompanyId(int companyId);

}
