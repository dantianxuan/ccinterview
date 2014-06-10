/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import com.interviewer.base.CcResult;
import com.interviewer.pojo.Interview;

/**
 * 咨询服务
 * 
 * @author jingyu.dan
 * @version $Id: InterviewService.java, v 0.1 2014-6-10 下午2:28:22 jingyu.dan Exp $
 */
public interface InterviewService {

    /**
     * 注册面试订单
     * 
     * @param interview
     * @return
     */
    public CcResult registInterview(Interview interview);
}
