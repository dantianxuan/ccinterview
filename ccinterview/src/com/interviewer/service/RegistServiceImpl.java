/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.CcResult;
import com.interviewer.dao.RegMailDAO;
import com.interviewer.mail.MailSender;
import com.interviewer.pojo.RegMail;

/**
 * 
 * @author jingyu.dan
 * @version $Id: RegistServiceImpl.java, v 0.1 2014-5-29 下午9:28:25 jingyu.dan Exp $
 */
public class RegistServiceImpl implements RegistService {

    @Autowired
    private RegMailDAO regMailDAO;
    /** mailsender */
    @Autowired
    private MailSender mailSender;

    @Override
    public CcResult regMail(RegMail regMail) {

        boolean isSend = mailSender.sendMail(regMail.getMail(), "欢迎注册");
        if (isSend) {
            regMailDAO.save(regMail);
            return new CcResult(regMail);
        }
        return new CcResult();

    }

    @Override
    public CcResult regInterviewer() {
        return null;
    }

    @Override
    public CcResult regJobSeeker() {
        return null;
    }

}
