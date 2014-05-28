/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.interviewer.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author jinsaichen
 */
public class RegMail implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -3123344636062972895L;
    private Integer           id;
    private String            mail;
    private String            token;
    private Date              gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
