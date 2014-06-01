package com.interviewer.pojo;

import java.util.Date;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */

public class Interview extends com.interviewer.base.ToString implements java.io.Serializable {

    // Fields    

    private Integer id;
    private Integer seekerId;
    private long    salary;
    private Date    gmtCreate;
    private Date    gmtFinish;

    // Constructors

    /** default constructor */
    public Interview() {
    }

    /** full constructor */
    public Interview(Integer seekerId, long salary, Date gmtCreate, Date gmtFinish) {
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

    public Integer getSeekerId() {
        return this.seekerId;
    }

    public void setSeekerId(Integer seekerId) {
        this.seekerId = seekerId;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtFinish() {
        return this.gmtFinish;
    }

    public void setGmtFinish(Date gmtFinish) {
        this.gmtFinish = gmtFinish;
    }

}