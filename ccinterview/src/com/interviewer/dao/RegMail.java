package com.interviewer.dao;

/**
 * RegMail entity. @author MyEclipse Persistence Tools
 */

public class RegMail implements java.io.Serializable {

	// Fields

	private RegMailId id;

	// Constructors

	/** default constructor */
	public RegMail() {
	}

	/** full constructor */
	public RegMail(RegMailId id) {
		this.id = id;
	}

	// Property accessors

	public RegMailId getId() {
		return this.id;
	}

	public void setId(RegMailId id) {
		this.id = id;
	}

}