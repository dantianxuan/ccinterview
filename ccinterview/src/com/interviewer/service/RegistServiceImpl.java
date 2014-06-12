/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.AbstractService;
import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcException;
import com.interviewer.base.CcResult;
import com.interviewer.core.MailSender;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.dao.JobseekerDAO;
import com.interviewer.dao.RegMailDAO;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.pojo.RegMail;
import com.interviewer.view.InterviewerVO;

/**
 * 
 * @author jingyu.dan
 * @version $Id: RegistServiceImpl.java, v 0.1 2014-5-29 下午9:28:25 jingyu.dan
 *          Exp $
 */
public class RegistServiceImpl extends AbstractService implements RegistService {

    @Autowired
    private RegMailDAO     regMailDAO;
    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private MailSender     mailSender;
    @Autowired
    private JobseekerDAO   jobseekerDAO;

    @Override
    public CcResult regMail(final RegMail regMail) {

        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                RegMail existRegMail = regMailDAO.findByMail(regMail.getMail());
                if (existRegMail == null) {
                    regMailDAO.save(regMail);
                    mailSender.sendMail(regMail);
                } else {
                    InterviewerVO interviewerVO = interviewerDAO.findByEmail(regMail.getMail());
                    if (interviewerVO != null) {
                        throw new CcException("您已经注册过该用户，请直接登录，如果忘记密码请点击忘记密码找回");
                    }
                    mailSender.sendMail(existRegMail);
                }
                return new CcResult(regMail);
            }
        });

    }

    /**
     * 注册成为一个面试官
     * 
     * @see com.interviewer.service.RegistService#regInterviewer(com.interviewer.pojo.Interviewer,
     *      int)
     */
    public CcResult regJobseeker(final Jobseeker jobseeker) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                AssertUtil.notNull(jobseeker, "非法的注册请求");
                AssertUtil.notBlank(jobseeker.getEmail(), "用户邮箱不能为空");
                AssertUtil.notBlank(jobseeker.getName(), "用户名称不能为空");
                AssertUtil.notBlank(jobseeker.getMobile(), "请输入手机号码");

                Jobseeker localJobseeker = jobseekerDAO.findByEmail(jobseeker.getEmail());
                if (localJobseeker != null) {
                    throw new CcException("该用户名称已经被注册！");
                }
                jobseekerDAO.save(jobseeker);
                return new CcResult(jobseeker);
            }
        });
    }

    /**
     * 注册成为一个面试官
     * 
     * @see com.interviewer.service.RegistService#regInterviewer(com.interviewer.pojo.Interviewer,
     *      int)
     */
    @Override
    public CcResult regInterviewer(final Interviewer interviewer, final int regMailId) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                RegMail regMail = regMailDAO.findById(regMailId);
                AssertUtil.notNull(regMail, "非法的注册请求");
                AssertUtil.state(StringUtils.equals(regMail.getMail(), interviewer.getEmail()),
                    "非法的账号，账号被篡改");
                InterviewerVO innerInterviewerVO = interviewerDAO.findByEmail(interviewer
                    .getEmail());
                if (innerInterviewerVO != null) {
                    throw new CcException("您已经注册过该用户，请直接登录，如果忘记密码请点击忘记密码找回");
                }
                interviewerDAO.save(interviewer);
                return new CcResult(interviewer);
            }
        });
    }

    @Override
    public CcResult getRegMainInfo(final String token) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                RegMail regMail = regMailDAO.findByToken(token);
                if (regMail == null) {
                    throw new CcException("无注册记录，请注册");
                }
                return new CcResult(regMail);
            }
        });
    }

}
