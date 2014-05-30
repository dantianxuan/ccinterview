/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.base;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.interviewer.dao.HibernateSessionFactory;

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
    public <T> T executeWithoutTransaction(Class<? extends CcResult> clazz, ServiceCallBack action) {
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
            logger.warn("无事务服务模板-业务异常：[" + e.getCode() + "](" + e.getMessage() + ")", e);
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
            session.getTransaction().rollback();
            return (T) result;
        } catch (Throwable e2) {
            logger.error("无事务服务模板-系统异常：", e2);
            session.getTransaction().rollback();
            return (T) result;
        } finally {
            session.close();
        }
        if (logger.isInfoEnabled()) {
            logger.info("退出无事务服务模板");
        }

        return (T) result;
    }

    @Override
    public <T> T execute(Class<? extends CcResult> clazz, ServiceCallBack action) {
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
            logger.warn("无事务服务模板-业务异常：[" + e.getCode() + "](" + e.getMessage() + ")", e);
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
            session.getTransaction().rollback();
            return (T) result;
        } catch (Throwable e2) {
            logger.error("无事务服务模板-系统异常：", e2);
            session.getTransaction().rollback();
            return (T) result;
        } finally {
            session.close();
        }
        if (logger.isInfoEnabled()) {
            logger.info("退出无事务服务模板");
        }

        return (T) result;
    }

}
