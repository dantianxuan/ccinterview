/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.AbstractService;
import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcException;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.dao.JobseekerDAO;
import com.interviewer.enums.InterviewStateEnum;
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.pojo.RegMail;

/**
 * 
 * @author jingyu.dan
 * @version $Id: InterviewServiceImpl.java, v 0.1 2014-6-10 下午2:30:26 jingyu.dan Exp $
 */
public class InterviewServiceImpl extends AbstractService implements InterviewService {

    @Autowired
    private InterviewDAO   interviewDAO;
    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private JobseekerDAO   jobseekerDAO;

    /** 
     * @see com.interviewer.service.InterviewService#registInterview(com.interviewer.pojo.Interview)
     */
    @Override
    public CcResult registInterview(final Interview interview) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                AssertUtil.notNull(interview, "不合法参数");
                Interviewer interviewer = interviewerDAO.findById(interview.getInterviewId());
                AssertUtil.notNull(interviewer, "咨询对象不存在，请检查");
                Jobseeker jobseeker = jobseekerDAO.findById(interview.getJobseekerId());
                AssertUtil.notNull(jobseeker, "用户不存在，请检查");
                interview.setGmtCreate(new Date());
                interview.setState(InterviewStateEnum.CREATE.getCode());
                interview.setGmtModified(new Date());
                interviewDAO.save(interview);
                return new CcResult(interview);
            }
        });
    }
}
