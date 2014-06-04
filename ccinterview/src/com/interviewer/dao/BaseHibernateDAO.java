package com.interviewer.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.util.CollectionUtils;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO<T> implements IBaseHibernateDAO {

    @Override
    public Session getSession() {
        return HibernateSessionFactory.getSession();
    }

    /**
     * 获取
     * 
     * @param list
     * @return
     */
    public T getLimit(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public void save(T transientInstance) {
        getSession().save(transientInstance);
    }

    public void update(T transientInstance) {
        getSession().update(transientInstance);
    }

    public void delete(T persistentInstance) {
        getSession().delete(persistentInstance);
    }

}