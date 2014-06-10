package com.interviewer.pojo;

import java.util.Date;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */

public class Interview extends com.interviewer.base.ToString implements java.io.Serializable {

    // Fields    

    private Integer id;
    private Integer jobseekerId;
    private Integer interviewId;
    private String  state;
    private String  memo;
    private String  orderId;
    private Date    gmtModified;
    private Date    gmtCreate;

    // Constructors

    /** default constructor */
    public Interview() {
    }

    /** full constructor */
    public Interview(Integer jobseekerId, Integer interviewId, String state, String memo,
                     String orderId, Date gmtModified, Date gmtCreate) {
        this.jobseekerId = jobseekerId;
        this.interviewId = interviewId;
        this.state = state;
        this.memo = memo;
        this.orderId = orderId;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobseekerId() {
        return this.jobseekerId;
    }

    public void setJobseekerId(Integer jobseekerId) {
        this.jobseekerId = jobseekerId;
    }

    public Integer getInterviewId() {
        return this.interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}