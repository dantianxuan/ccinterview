/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.CcConstrant;
import com.interviewer.base.ServiceTemplate;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.Jobseeker;

/**
 * 
 * controller的基类
 * @author jingyu.dan
 * @version $Id: BaseController.java, v 0.1 2014-5-29 下午11:17:50 jingyu.dan Exp $
 */
public class BaseController {

    @Autowired
    protected ServiceTemplate serviceTemplate;

    public Jobseeker getJobseekerInSession(HttpSession session) {
        Object jobseeker = session.getAttribute(CcConstrant.SESSION_JOBSEEKER_OBJECT);
        if (session != null) {
            return (Jobseeker) jobseeker;
        } else {
            return null;
        }
    }

    public Interviewer getInterviewerInSession(HttpSession session) {
        Object interivewer = session.getAttribute(CcConstrant.SESSION_INTERVIEWER_OBJECT);
        if (interivewer != null) {
            return (Interviewer) interivewer;
        } else {
            return null;
        }
    }

}
