package com.interviewer.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.pojo.Company;
import com.interviewer.pojo.Interviewer;
import com.interviewer.view.InterviewerVO;

/**
 	* A data access object (DAO) providing persistence and search support for Interviewer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Interviewer
  * @author MyEclipse Persistence Tools 
 */

public class InterviewerDAO extends BaseHibernateDAO<Interviewer> {

    @Autowired
    private CompanyDAO         companyDAO;
    //property constants
    public static final String NAME        = "name";
    public static final String EMAIL       = "email";
    public static final String MOBILE      = "mobile";
    public static final String DESCRIPTION = "description";
    public static final String COMPANY_ID  = "companyId";
    public static final String PHOTO       = "photo";
    public static final String PASSWD      = "passwd";

    public InterviewerVO findById(java.lang.Integer id) {
        Interviewer instance = (Interviewer) getSession().get("com.interviewer.pojo.Interviewer",
            id);
        if (instance == null) {
            return null;
        }
        Company company = companyDAO.findById(instance.getCompanyId());
        return new InterviewerVO(instance, company);
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

    public InterviewerVO findByEmail(Object email) {
        List<Interviewer> interviews = findByProperty(EMAIL, email);
        Interviewer interviewer= getLimit(interviews);
        if(interviewer==null){
            return null;
        }
        Company company = companyDAO.findById(interviewer.getCompanyId());
        return new InterviewerVO(interviewer, company);
    }

}