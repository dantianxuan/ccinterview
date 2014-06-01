/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.interviewer.query;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.base.ServiceTemplate;
import com.interviewer.dao.UserInfoDAO;
import com.interviewer.pojo.UserInfo;
import com.interviewer.util.LogUtil;

/**
 * 用户查询服务
 * @author jinsaichen
 * @version $Id: QueryUserInfoServiceImpl.java, v 0.1 2014-6-1 上午8:59:54 jinsaichen Exp $
 */
public class QueryUserInfoServiceImpl implements QueryUserInfoService {

    /**日志 */
    private static final Logger logger = Logger.getLogger(QueryUserInfoServiceImpl.class);

    /**公司数据库操作类 */
    @Autowired
    private UserInfoDAO         userInfoDAO;

    /**事物模板类 */
    @Autowired
    private ServiceTemplate     serviceTemplate;

    /** 
     * @see com.interviewer.query.QueryUserInfoService#queryAllUserInfo()
     */
    @Override
    public CcResult queryAllUserInfo() {
        LogUtil.info(logger, "开始查询所有用户信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                List<UserInfo> userInfos = userInfoDAO.findAll();
                return new CcResult(userInfos);
            }
        });
    }

    /** 
     * @see com.interviewer.query.QueryUserInfoService#queryUserInfoById(int)
     */
    @Override
    public CcResult queryUserInfoById(final int id) {
        LogUtil.info(logger, "开始查询所有用户id");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            @Override
            public CcResult executeService() {
                UserInfo userInfo = userInfoDAO.findById(id);
                return new CcResult(userInfo);
            }
        });
    }

    @Override
    public CcResult queryUserInfoByCompanyId(final int companyId) {
        LogUtil.info(logger, "通过公司id开始查询所有用户");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            public void check() {
                if (companyId == 0) {
                    LogUtil.warn(logger, "通过公司id查询用户companyId=" + companyId);
                }
            }

            @Override
            public CcResult executeService() {
                List<UserInfo> userInfos = userInfoDAO.findByCompanyId(companyId);

                if (CollectionUtils.isEmpty(userInfos)) {
                    LogUtil.warn(logger, "通过companyId查询用户为空");
                }
                return new CcResult(userInfos);
            }
        });
    }
}
