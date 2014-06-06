/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.view;

import com.interviewer.base.ToString;
import com.interviewer.pojo.Company;

/**
 * 
 * @author jingyudan
 * @version $Id: CompanyBriefVO.java, v 0.1 2014-6-6 上午7:13:34 jingyudan Exp $
 */
public class CompanyBriefVO extends ToString {
    /**  */
    private static final long serialVersionUID = 1L;

    private Company           company;

    private int               interviewCount;

    private int               interviewerCount;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getInterviewCount() {
        return interviewCount;
    }

    public void setInterviewCount(int interviewCount) {
        this.interviewCount = interviewCount;
    }

    public int getInterviewerCount() {
        return interviewerCount;
    }

    public void setInterviewerCount(int interviewerCount) {
        this.interviewerCount = interviewerCount;
    }

}
