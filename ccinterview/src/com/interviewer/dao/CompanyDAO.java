package com.interviewer.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interviewer.pojo.Company;

/**
 	* A data access object (DAO) providing persistence and search support for Company entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Company
  * @author MyEclipse Persistence Tools 
 */

public class CompanyDAO extends BaseHibernateDAO {
    private static final Logger log         = LoggerFactory.getLogger(CompanyDAO.class);
    //property constants
    public static final String  NAME        = "name";
    public static final String  DESC        = "desc";
    public static final String  LINK        = "link";
    public static final String  CATEGORY_ID = "categoryId";
    public static final String  MAIL_SUFIX  = "mailSufix";

    public void save(Company transientInstance) {
        log.debug("saving Company instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Company persistentInstance) {
        log.debug("deleting Company instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Company findById(java.lang.Integer id) {
        log.debug("getting Company instance with id: " + id);
        try {
            Company instance = (Company) getSession().get("com.interviewer.pojo.Company", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Company instance) {
        log.debug("finding Company instance by example");
        try {
            List results = getSession().createCriteria("com.interviewer.pojo.Company")
                .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding Company instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from Company as model where model." + propertyName + "= ?";
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

    public List findByDesc(Object desc) {
        return findByProperty(DESC, desc);
    }

    public List findByLink(Object link) {
        return findByProperty(LINK, link);
    }

    public List findByCategoryId(Object categoryId) {
        return findByProperty(CATEGORY_ID, categoryId);
    }

    public List findByMailSufix(Object mailSufix) {
        return findByProperty(MAIL_SUFIX, mailSufix);
    }

    public List findAll() {
        log.debug("finding all Company instances");
        try {
            String queryString = "from Company";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Company merge(Company detachedInstance) {
        log.debug("merging Company instance");
        try {
            Company result = (Company) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Company instance) {
        log.debug("attaching dirty Company instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Company instance) {
        log.debug("attaching clean Company instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}