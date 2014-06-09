package com.interviewer.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interviewer.pojo.Interviewer;

/**
 	* A data access object (DAO) providing persistence and search support for Interviewer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Interviewer
  * @author MyEclipse Persistence Tools 
 */

public class InterviewerDAO extends BaseHibernateDAO<Interviewer> {
    private static final Logger log         = LoggerFactory.getLogger(InterviewerDAO.class);
    //property constants
    public static final String  NAME        = "name";
    public static final String  EMAIL       = "email";
    public static final String  MOBILE      = "mobile";
    public static final String  DESCRIPTION = "description";
    public static final String  COMPANY_ID  = "companyId";
    public static final String  PHOTO       = "photo";
    public static final String  PASSWD      = "passwd";

    public Interviewer findById(java.lang.Integer id) {
        log.debug("getting Interviewer instance with id: " + id);
        try {
            Interviewer instance = (Interviewer) getSession().get(
                "com.interviewer.pojo.Interviewer", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Interviewer> findByProperty(String propertyName, Object value) {
        String queryString = "from Interviewer as model where model." + propertyName + "= ?";
        Query queryObject = getSession().createQuery(queryString);
        queryObject.setParameter(0, value);
        return queryObject.list();

    }

    public List<Interviewer> findByCompanyId(int companyId) {
        return findByProperty(COMPANY_ID, companyId);

    }

    public Interviewer findByEmail(Object email) {
        List<Interviewer> interviews = findByProperty(EMAIL, email);
        return getLimit(interviews);
    }

}