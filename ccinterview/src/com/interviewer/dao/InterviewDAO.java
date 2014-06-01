package com.interviewer.dao;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.interviewer.pojo.Interview;

/**
 	* A data access object (DAO) providing persistence and search support for Interview entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Interview
  * @author MyEclipse Persistence Tools 
 */

public class InterviewDAO extends BaseHibernateDAO {
    private static final Log   log       = LogFactory.getLog(InterviewDAO.class);
    //property constants
    public static final String SEEKER_ID = "seekerId";
    public static final String SALARY    = "salary";

    public void save(Interview transientInstance) {
        log.debug("saving Interview instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Interview persistentInstance) {
        log.debug("deleting Interview instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Interview findById(java.lang.Integer id) {
        log.debug("getting Interview instance with id: " + id);
        try {
            Interview instance = (Interview) getSession().get("com.interviewer.pojo.Interview", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Interview instance) {
        log.debug("finding Interview instance by example");
        try {
            List results = getSession().createCriteria("com.interviewer.pojo.Interview")
                .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Interview instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from Interview as model where model." + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findBySeekerId(Object seekerId) {
        return findByProperty(SEEKER_ID, seekerId);
    }

    public List findBySalary(Object salary) {
        return findByProperty(SALARY, salary);
    }

    public List findAll() {
        log.debug("finding all Interview instances");
        try {
            String queryString = "from Interview";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Interview merge(Interview detachedInstance) {
        log.debug("merging Interview instance");
        try {
            Interview result = (Interview) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Interview instance) {
        log.debug("attaching dirty Interview instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Interview instance) {
        log.debug("attaching clean Interview instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}