package com.interviewer.pojo;

import java.util.Date;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

    // Fields    

    private Integer id;
    private String  name;
    private String  email;
    private String  mobile;
    private Date    gmtCreate;
    private Date    gmtModified;
    private String  desc;
    private Integer levelId;
    private Integer companyId;
    private String  companyName;

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    /** full constructor */
    public UserInfo(String name, String email, String mobile, Date gmtCreate, Date gmtModified,
                    String desc, Integer levelId, Integer companyId, String companyName) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.desc = desc;
        this.levelId = levelId;
        this.companyId = companyId;
        this.companyName = companyName;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getLevelId() {
        return this.levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}