package com.interviewer.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.base.ServiceTemplate;
import com.interviewer.dao.UserInfoDAO;
import com.interviewer.pojo.UserInfo;
import com.interviewer.util.LogUtil;

/**
 * 用户操作类
 * 
 * @author jinsaichen
 * @version $Id: UserInfoServiceImpl.java, v 0.1 2014-6-1 下午12:55:32 jinsaichen Exp $
 */
public class UserInfoServiceImpl implements UserInfoService {

    /**日志 */
    private static final Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
    /** 用户数据库操作类*/
    @Autowired
    private UserInfoDAO         userInfoDAO;

    /**事物模板类 */
    @Autowired
    private ServiceTemplate     serviceTemplate;

    @Override
    public CcResult updateUserInfo(final UserInfo userInfo) {
        LogUtil.info(logger, "开始修改用户信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            public void check() {
                if (userInfo == null) {
                    LogUtil.warn(logger, "入参为空userInfo=" + userInfo);
                }
            }

            @Override
            public CcResult executeService() {

                // List<UserInfo> userInfos = userInfoDAO.
                return new CcResult();
            }
        });
    }

    @Override
    public CcResult deleteUserInfo(int id) {
        return null;
    }

}
