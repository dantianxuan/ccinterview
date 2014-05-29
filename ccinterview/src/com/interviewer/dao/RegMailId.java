package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * RegMailId entity. @author MyEclipse Persistence Tools
 */

public class RegMailId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mail;
	private String token;
	private Timestamp gmtCreate;

	// Constructors

	/** default constructor */
	public RegMailId() {
	}

	/** full constructor */
	public RegMailId(Integer id, String mail, String token, Timestamp gmtCreate) {
		this.id = id;
		this.mail = mail;
		this.token = token;
		this.gmtCreate = gmtCreate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RegMailId))
			return false;
		RegMailId castOther = (RegMailId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getMail() == castOther.getMail()) || (this.getMail() != null
						&& castOther.getMail() != null && this.getMail()
						.equals(castOther.getMail())))
				&& ((this.getToken() == castOther.getToken()) || (this
						.getToken() != null && castOther.getToken() != null && this
						.getToken().equals(castOther.getToken())))
				&& ((this.getGmtCreate() == castOther.getGmtCreate()) || (this
						.getGmtCreate() != null
						&& castOther.getGmtCreate() != null && this
						.getGmtCreate().equals(castOther.getGmtCreate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getMail() == null ? 0 : this.getMail().hashCode());
		result = 37 * result
				+ (getToken() == null ? 0 : this.getToken().hashCode());
		result = 37 * result
				+ (getGmtCreate() == null ? 0 : this.getGmtCreate().hashCode());
		return result;
	}

}