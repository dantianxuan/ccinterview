package com.interviewer.dao;

import com.interviewer.pojo.RegMail;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for RegMail entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.RegMail
  * @author MyEclipse Persistence Tools 
 */

public class RegMailDAO extends BaseHibernateDAO {
    private static final Logger log   = LoggerFactory.getLogger(RegMailDAO.class);
    //property constants
    public static final String  MAIL  = "mail";
    public static final String  TOKEN = "token";

    public void save(RegMail transientInstance) {
        log.debug("saving RegMail instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(RegMail persistentInstance) {
        log.debug("deleting RegMail instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public RegMail findById(java.lang.Integer id) {
        log.debug("getting RegMail instance with id: " + id);
        try {
            RegMail instance = (RegMail) getSession().get("com.interviewer.pojo.RegMail", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(RegMail instance) {
        log.debug("finding RegMail instance by example");
        try {
            List results = getSession().createCriteria("com.interviewer.pojo.RegMail")
                .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding RegMail instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from RegMail as model where model." + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByMail(Object mail) {
        return findByProperty(MAIL, mail);
    }

    public List findByToken(Object token) {
        return findByProperty(TOKEN, token);
    }

    public List findAll() {
        log.debug("finding all RegMail instances");
        try {
            String queryString = "from RegMail";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public RegMail merge(RegMail detachedInstance) {
        log.debug("merging RegMail instance");
        try {
            RegMail result = (RegMail) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RegMail instance) {
        log.debug("attaching dirty RegMail instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(RegMail instance) {
        log.debug("attaching clean RegMail instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}