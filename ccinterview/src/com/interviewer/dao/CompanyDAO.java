package com.interviewer.dao;

import java.util.List;

import org.hibernate.Query;

import com.interviewer.pojo.Company;

/**
 	* A data access object (DAO) providing persistence and search support for Company entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Company
  * @author MyEclipse Persistence Tools 
 */

public class CompanyDAO extends BaseHibernateDAO<Company> {
    //property constants
    public static final String NAME        = "name";
    public static final String DESCRIPTION = "description";
    public static final String LINK        = "link";
    public static final String CATEGORY_ID = "categoryId";
    public static final String MAIL_SUFFIX = "mailSuffix";

    public Company findById(java.lang.Integer id) {
        Company instance = (Company) getSession().get("com.interviewer.pojo.Company", id);
        return instance;
    }

    public List<Company> findByNanmeFuzzy(String name) {
        Query query = getSession().createQuery(
            "FROM Company where name like '%" + name + "%' limit 100");
        return query.list();
    }

    public List<Company> findRecentList(int topx) {
        String hql = "from Company order by gmtCreate desc";
        return findPageByQuery(0, topx, hql, null);
    }

}