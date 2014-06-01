package com.interviewer.dao;

import com.interviewer.pojo.UserInfo;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO {
    private static final Logger log          = LoggerFactory.getLogger(UserInfoDAO.class);
    //property constants
    public static final String  NAME         = "name";
    public static final String  EMAIL        = "email";
    public static final String  MOBILE       = "mobile";
    public static final String  DESC         = "desc";
    public static final String  LEVEL_ID     = "levelId";
    public static final String  COMPANY_ID   = "companyId";
    public static final String  COMPANY_NAME = "companyName";

    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public UserInfo findById(java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession().get("com.interviewer.pojo.UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession().createCriteria("com.interviewer.pojo.UserInfo")
                .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding UserInfo instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from UserInfo as model where model." + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByName(Object name) {
        return findByProperty(NAME, name);
    }

    public List findByEmail(Object email) {
        return findByProperty(EMAIL, email);
    }

    public List findByMobile(Object mobile) {
        return findByProperty(MOBILE, mobile);
    }

    public List findByDesc(Object desc) {
        return findByProperty(DESC, desc);
    }

    public List findByLevelId(Object levelId) {
        return findByProperty(LEVEL_ID, levelId);
    }

    public List findByCompanyId(Object companyId) {
        return findByProperty(COMPANY_ID, companyId);
    }

    public List findByCompanyName(Object companyName) {
        return findByProperty(COMPANY_NAME, companyName);
    }

    public List findAll() {
        log.debug("finding all UserInfo instances");
        try {
            String queryString = "from UserInfo";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}