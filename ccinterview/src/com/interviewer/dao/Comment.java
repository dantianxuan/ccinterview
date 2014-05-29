package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String comment;
	private String themeType;
	private Integer themeId;
	private Timestamp gmtCreate;
	private String creator;
	private Timestamp gmtModified;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String comment, String themeType, Integer themeId,
			Timestamp gmtCreate, String creator, Timestamp gmtModified) {
		this.comment = comment;
		this.themeType = themeType;
		this.themeId = themeId;
		this.gmtCreate = gmtCreate;
		this.creator = creator;
		this.gmtModified = gmtModified;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getThemeType() {
		return this.themeType;
	}

	public void setThemeType(String themeType) {
		this.themeType = themeType;
	}

	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getGmtModified() {
		return this.gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}

}