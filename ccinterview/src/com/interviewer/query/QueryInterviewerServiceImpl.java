/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.interviewer.query;

import java.util.List;

import org.apache.log4j.Logger;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.base.ServiceTemplate;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.pojo.Interview;
import com.interviewer.util.LogUtil;

/**
 * 查询面试官服务
 * @author jinsaichen
 * @version $Id: QueryInterviewerServiceImpl.java, v 0.1 2014-6-1 上午8:08:27 jinsaichen Exp $
 */
public class QueryInterviewerServiceImpl implements QueryInterviewerService {
    
    /**日志 */
    private static final Logger logger = Logger.getLogger(QueryCompanyServiceImpl.class);

    /**公司数据库操作类 */
    private InterviewDAO          interviewDAO;

    /**事物模板类 */
    private ServiceTemplate     serviceTemplate;

    /** 
     * @see com.interviewer.query.QueryInterviewerService#queryAllInterview()
     */
    @Override
    public CcResult queryAllInterview() {
        LogUtil.info(logger, "开始查询所有面试人员信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                List<Interview> interviews = interviewDAO.findAll();
                return new CcResult(interviews);
            }
        });

    }

    /** 
     * @see com.interviewer.query.QueryInterviewerService#queryInterviewById()
     */
    @Override
    public CcResult queryInterviewById(final int id) {
        
        LogUtil.info(logger, "开始查询所有面试人员信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                Interview interview = interviewDAO.findById(id);
                return new CcResult(interview);
            }
        });

    }

}
