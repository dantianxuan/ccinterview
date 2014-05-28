package com.interviewer.service;

import org.apache.log4j.Logger;

import com.interviewer.base.TemplateOperate;
import com.interviewer.model.RegMail;
import com.interviewer.util.LogUtil;

public class RegMailServiceImpl extends TemplateOperate implements
		RegMailService {

	/** 日志Logger */
	private static final Logger logger = Logger
			.getLogger(RegMailServiceImpl.class);

	@Override
	public void insertRegMail(RegMail regMail) {
		LogUtil.info(logger, "开始插入邮箱地址" + regMail);
		insert(regMail);
		
		LogUtil.info(logger, "邮箱插入成功");

	}

}
