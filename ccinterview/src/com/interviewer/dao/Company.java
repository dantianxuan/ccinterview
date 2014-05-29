package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String desc;
	private String link;
	private Timestamp gmtCreate;
	private Integer categoryId;
	private String mailSufix;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(String name, String desc, String link, Timestamp gmtCreate,
			Integer categoryId, String mailSufix) {
		this.name = name;
		this.desc = desc;
		this.link = link;
		this.gmtCreate = gmtCreate;
		this.categoryId = categoryId;
		this.mailSufix = mailSufix;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getMailSufix() {
		return this.mailSufix;
	}

	public void setMailSufix(String mailSufix) {
		this.mailSufix = mailSufix;
	}

}