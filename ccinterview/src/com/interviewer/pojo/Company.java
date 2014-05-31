package com.interviewer.pojo;

import java.util.Date;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company extends com.interviewer.base.ToString implements java.io.Serializable {

    // Fields    

    private Integer id;
    private String  name;
    private String  desc;
    private String  link;
    private Date    gmtCreate;
    private Integer categoryId;
    private String  mailSuffix;

    // Constructors

    /** default constructor */
    public Company() {
    }

    /** full constructor */
    public Company(String name, String desc, String link, Date gmtCreate, Integer categoryId,
                   String mailSuffix) {
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.gmtCreate = gmtCreate;
        this.categoryId = categoryId;
        this.mailSuffix = mailSuffix;
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

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMailSuffix() {
        return this.mailSuffix;
    }

    public void setMailSuffix(String mailSuffix) {
        this.mailSuffix = mailSuffix;
    }

}