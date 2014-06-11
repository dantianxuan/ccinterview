/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.view;

import com.interviewer.base.ToString;
import com.interviewer.pojo.Company;
import com.interviewer.pojo.Interviewer;

/**
 * 面试官基本信息对象
 * 包含面试官基本信息，公司信息等
 * 
 * @author jingyu.dan
 * @version $Id: InterviewerVO.java, v 0.1 2014-6-1 下午5:49:47 jingyu.dan Exp $
 */
public class InterviewerVO extends ToString {

    /**  */
    private static final long serialVersionUID = 1L;

    /**面试官*/
    private Interviewer       interviewer;

    /**公司信息*/
    private Company           company;

    public InterviewerVO(Interviewer interviewer, Company company) {
        this.interviewer = interviewer;
        this.company = company;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
