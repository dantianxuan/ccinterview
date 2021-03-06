/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.base;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.interviewer.dao.HibernateSessionFactory;
import com.interviewer.util.LogUtil;

/**
 * 
 * @author jingyu.dan
 * @version $Id: ServiceTemplateImpl.java, v 0.1 2014-5-30 下午5:54:22 jingyu.dan Exp $
 */
@SuppressWarnings("unchecked")
public class ServiceTemplateImpl implements ServiceTemplate {

    /**日志 */
    private static final Logger logger = Logger.getLogger(ServiceTemplateImpl.class);

    private Session getSession() {
        return HibernateSessionFactory.getSession();
    }

    @Override
    public <T> T execute(Class<? extends CcResult> clazz, ServiceCallBack action) {
        CcResult result = null;
        try {
            result = clazz.newInstance();
            // 执行校验
            action.check();
            // 执行处理逻辑
            result = action.executeService();
            if (result == null || !(result instanceof CcResult)) {
                throw new RuntimeException("逻辑错误");
            }
        } catch (CcException e) {
            // 业务异常捕获
            logger.warn("无事务服务模板-业务异常：[" + e.getCode() + "](" + e.getMessage() + ")", e);
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
            return (T) result;
        } catch (Throwable e2) {
            logger.error("无事务服务模板-系统异常：", e2);
            return (T) result;
        }
        if (logger.isInfoEnabled()) {
            logger.info("退出无事务服务模板");
        }

        return (T) result;
    }

    @Override
    public <T> T executeWithTx(Class<? extends CcResult> clazz, ServiceCallBack action) {
        CcResult result = null;
        Session session = getSession();
        try {
            session = getSession();
            session.beginTransaction();
            result = clazz.newInstance();
            // 执行校验
            action.check();
            // 执行处理逻辑
            result = action.executeService();
            if (result == null || !(result instanceof CcResult)) {
                throw new RuntimeException("逻辑错误");
            }
            session.getTransaction().commit();
        } catch (CcException e) {
            // 业务异常捕获
            LogUtil.error(logger, e, "【业务异常】");
            result.setCode(e.getCode());
            result.setSuccess(false);
            result.setMessage(e.getLocalizedMessage());
            session.getTransaction().rollback();
            return (T) result;
        } catch (Throwable e2) {
            result.setSuccess(false);
            LogUtil.error(logger, e2, "【系统异常】");
            session.getTransaction().rollback();
            return (T) result;
        } finally {
            session.close();
        }
        LogUtil.info(logger, "【退出无事务服务模板】", result);
        return (T) result;
    }

}
