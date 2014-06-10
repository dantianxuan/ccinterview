package com.interviewer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interviewer.pojo.Interview;

/**
 	* A data access object (DAO) providing persistence and search support for Interview entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.interviewer.pojo.Interview
  * @author MyEclipse Persistence Tools 
 */

public class InterviewDAO extends BaseHibernateDAO<Interview> {
    private static final Logger log          = LoggerFactory.getLogger(InterviewDAO.class);
    //property constants
    public static final String  JOBSEEKER_ID = "jobseekerId";
    public static final String  INTERVIEW_ID = "interviewId";
    public static final String  STATE        = "state";
    public static final String  MEMO         = "memo";
    public static final String  ORDER_ID     = "orderId";


}