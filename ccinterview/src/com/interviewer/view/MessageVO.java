/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.view;

import com.interviewer.base.ToString;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.pojo.Message;

/**
 * 
 * @author jingyu.dan
 * @version $Id: MessageVO.java, v 0.1 2014-6-12 下午2:27:41 jingyu.dan Exp $
 */
public class MessageVO extends ToString {
    private static final long serialVersionUID = 1L;

    private InterviewerVO     interviewerVO;

    private Jobseeker         jobseeker;

    private Message           message;

    public InterviewerVO getInterviewerVO() {
        return interviewerVO;
    }

    public void setInterviewerVO(InterviewerVO interviewerVO) {
        this.interviewerVO = interviewerVO;
    }

    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
