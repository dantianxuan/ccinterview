/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.interviewer.base.AbstractService;
import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcException;
import com.interviewer.base.CcResult;
import com.interviewer.core.MailSender;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.dao.RegMailDAO;
import com.interviewer.dao.UserInfoDAO;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.RegMail;
import com.interviewer.pojo.UserInfo;
import com.interviewer.util.LogUtil;

/**
 * 
 * @author jingyu.dan
 * @version $Id: RegistServiceImpl.java, v 0.1 2014-5-29 下午9:28:25 jingyu.dan
 *          Exp $
 */
public class RegistServiceImpl extends AbstractService implements RegistService {

	private static final Logger log = Logger.getLogger(RegistServiceImpl.class);

	@Autowired
	private RegMailDAO regMailDAO;
	@Autowired
	private InterviewerDAO interviewerDAO;
	/** mailsender */
	@Autowired
	private MailSender mailSender;

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public CcResult regMail(final RegMail regMail) {

		return serviceTemplate.execute(CcResult.class,
				new BlankServiceCallBack() {
					@Override
					public CcResult executeService() {
						RegMail existRegMail = regMailDAO.findByMail(regMail
								.getMail());
						if (existRegMail == null) {
							regMailDAO.save(regMail);
							mailSender.sendMail(regMail);
						} else {
							Interviewer interviewer = interviewerDAO
									.findByEmail(regMail.getMail());
							if (interviewer != null) {
								throw new CcException(
										"您已经注册过该用户，请直接登录，如果忘记密码请点击忘记密码找回");
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
	@Override
	public CcResult regInterviewer(final Interviewer interviewer,
			final int regMailId) {
		return serviceTemplate.execute(CcResult.class,
				new BlankServiceCallBack() {
					@Override
					public CcResult executeService() {
						RegMail regMail = regMailDAO.findById(regMailId);
						AssertUtil.notNull(regMail, "非法的注册请求");
						AssertUtil.state(StringUtils.equals(regMail.getMail(),
								interviewer.getEmail()), "非法的账号，账号被篡改");
						Interviewer innerInterviewer = interviewerDAO
								.findByEmail(interviewer.getEmail());
						if (innerInterviewer != null) {
							throw new CcException(
									"您已经注册过该用户，请直接登录，如果忘记密码请点击忘记密码找回");
						}
						interviewerDAO.save(interviewer);
						return new CcResult(interviewer);
					}
				});
	}

	@Override
	public CcResult getRegMainInfo(final String token) {
		return serviceTemplate.execute(CcResult.class,
				new BlankServiceCallBack() {
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

	@Override
	public CcResult regUserInfo(final UserInfo userInfo) {

		return serviceTemplate.execute(CcResult.class,
				new BlankServiceCallBack() {
					@Override
					public CcResult executeService() {
						userInfoDAO.save(userInfo);
						return new CcResult();
					}
				});
	}

}
