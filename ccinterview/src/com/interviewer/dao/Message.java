package com.interviewer.dao;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private String message;
	private Integer fromUser;
	private Integer toUser;
	private Timestamp gmtCreate;
	private String state;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String message, Integer fromUser, Integer toUser,
			Timestamp gmtCreate, String state) {
		this.message = message;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.gmtCreate = gmtCreate;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(Integer fromUser) {
		this.fromUser = fromUser;
	}

	public Integer getToUser() {
		return this.toUser;
	}

	public void setToUser(Integer toUser) {
		this.toUser = toUser;
	}

	public Timestamp getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}