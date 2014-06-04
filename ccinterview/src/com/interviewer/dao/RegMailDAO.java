package com.interviewer.dao;

import java.util.List;

import org.hibernate.Query;

import com.interviewer.pojo.RegMail;

/**
    * A data access object (DAO) providing persistence and search support for RegMail entities.
            * Transaction control of the save(), update() and delete() operations 
        can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. 
        Each of these methods provides additional information for how to configure it for the desired type of transaction control.  
     * @see com.interviewer.pojo.RegMail
  * @author MyEclipse Persistence Tools 
 */

public class RegMailDAO extends BaseHibernateDAO<RegMail> {
    //property constants
    public static final String MAIL  = "mail";
    public static final String TOKEN = "token";

    public RegMail findById(java.lang.Integer id) {
        RegMail instance = (RegMail) getSession().get("com.interviewer.pojo.RegMail", id);
        return instance;
    }

    @SuppressWarnings("unchecked")
    public List<RegMail> findByProperty(String propertyName, Object value) {
        String queryString = "from RegMail as model where model." + propertyName + "= ?";
        Query queryObject = getSession().createQuery(queryString);
        queryObject.setParameter(0, value);
        return queryObject.list();
    }

    public RegMail findByMail(Object mail) {
        List<RegMail> regMails = findByProperty(MAIL, mail);
        return getLimit(regMails);
    }

    public RegMail findByToken(Object token) {
        List<RegMail> regMails = findByProperty(TOKEN, token);
        return getLimit(regMails);
    }

}