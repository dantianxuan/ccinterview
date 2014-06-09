/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import com.interviewer.base.CcResult;
import com.interviewer.pojo.UserInfo;

/**
 * 用户操作服务
 * @author jingyu.dan
 * @version $Id: JobSeekerService.java, v 0.1 2014-5-28 下午8:35:57 jingyu.dan Exp $
 */
public interface UserInfoService {
    /**
     * 修改用户信息
     * 
     * @param userInfo
     * @return
     */
    public CcResult updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     * 
     * @param id
     * @return
     */
    public CcResult deleteUserInfo(int id);

}
