package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */

public class Interview implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer interviewerId;
	private Integer seekerId;
	private Long salary;
	private Timestamp gmtCreate;
	private Timestamp gmtFinish;

	// Constructors

	/** default constructor */
	public Interview() {
	}

	/** full constructor */
	public Interview(Integer interviewerId, Integer seekerId, Long salary,
			Timestamp gmtCreate, Timestamp gmtFinish) {
		this.interviewerId = interviewerId;
		this.seekerId = seekerId;
		this.salary = salary;
		this.gmtCreate = gmtCreate;
		this.gmtFinish = gmtFinish;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInterviewerId() {
		return this.interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public Integer getSeekerId() {
		return this.seekerId;
	}

	public void setSeekerId(Integer seekerId) {
		this.seekerId = seekerId;
	}

	public Long getSalary() {
		return this.salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Timestamp getGmtFinish() {
		return this.gmtFinish;
	}

	public void setGmtFinish(Timestamp gmtFinish) {
		this.gmtFinish = gmtFinish;
	}

}