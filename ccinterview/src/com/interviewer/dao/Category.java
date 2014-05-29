package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String category;
	private Timestamp gmtCreate;
	private Integer themeId;
	private Integer themeType;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String category, Timestamp gmtCreate, Integer themeId,
			Integer themeType) {
		this.category = category;
		this.gmtCreate = gmtCreate;
		this.themeId = themeId;
		this.themeType = themeType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Integer getThemeType() {
		return this.themeType;
	}

	public void setThemeType(Integer themeType) {
		this.themeType = themeType;
	}

}