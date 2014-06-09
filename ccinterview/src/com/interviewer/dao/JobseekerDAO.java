package com.interviewer.dao;

import java.util.List;

import org.hibernate.Query;

import com.interviewer.pojo.Jobseeker;

/**
 	* A data access object (DAO) providing persistence and search support for Jobseeker entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Jobseeker
  * @author MyEclipse Persistence Tools 
 */

public class JobseekerDAO extends BaseHibernateDAO<Jobseeker> {
    //property constants
    public static final String NAME   = "name";
    public static final String PASSWD = "passwd";
    public static final String MOBILE = "mobile";
    public static final String EMAIL  = "email";
    public static final String PHOTO  = "photo";

    public Jobseeker findById(java.lang.Integer id) {
        Jobseeker instance = (Jobseeker) getSession().get("com.interviewer.pojo.Jobseeker", id);
        return instance;
    }

    public List findByProperty(String propertyName, Object value) {
        String queryString = "from Jobseeker as model where model." + propertyName + "= ?";
        Query queryObject = getSession().createQuery(queryString);
        queryObject.setParameter(0, value);
        return queryObject.list();
    }

    public Jobseeker findByEmail(Object mail) {
        List list = findByProperty(EMAIL, mail);
        return getLimit(list);
    }

}