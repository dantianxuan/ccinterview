/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.view;

import com.interviewer.base.ToString;
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Jobseeker;

/**
 * 
 * @author jingyudan
 * @version $Id: InterviewVO.java, v 0.1 2014-6-11 下午8:21:25 jingyudan Exp $
 */
public class InterviewVO extends ToString {

    /**  */
    private static final long serialVersionUID = 1L;

    private Interview         interview;

    private Jobseeker         jobseeker;

    private InterviewerVO     interviewerVO;

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public InterviewerVO getInterviewerVO() {
        return interviewerVO;
    }

    public void setInterviewerVO(InterviewerVO interviewerVO) {
        this.interviewerVO = interviewerVO;
    }

}
