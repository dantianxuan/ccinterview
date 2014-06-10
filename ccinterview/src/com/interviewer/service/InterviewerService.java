/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import com.interviewer.base.CcResult;
import com.interviewer.pojo.Interviewer;

/**
 * 
 * @author jingyu.dan
 * @version $Id: InterviwerService.java, v 0.1 2014-5-28 下午8:36:13 jingyu.dan Exp $
 */
public interface InterviewerService {

    /**
     * 修改面试官信息
     * 
     * @param userInfo
     * @return
     */
    public CcResult updateInterviewer(Interviewer interviewer);

    /**
     * 删除面试官信息
     * 
     * @param id
     * @return
     */
    public CcResult deleteInterviewer(int id);

}
