/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import com.interviewer.base.CcResult;
import com.interviewer.pojo.RegMail;

/**
 * 用户注册服务
 * 
 * @author jingyu.dan
 * @version $Id: RegistService.java, v 0.1 2014-5-28 下午7:59:20 jingyu.dan Exp $
 */
public interface RegistService {
    /**
     * 注册信息
     */
    public CcResult regMail(RegMail regMail);

    /**
     * 注册信息
     */
    public CcResult regInterviewer();

    /**
     * 注册信息
     */
    public CcResult regJobSeeker();
}
