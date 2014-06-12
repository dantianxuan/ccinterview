package com.interviewer.pojo;

import java.util.Date;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */

public class Interview extends com.interviewer.base.ToString implements java.io.Serializable {

    // Fields    

    private Integer id;
    private Integer jobseekerId;
    private Integer interviewerId;
    private Integer step;
    private String  memo;
    private String  orderId;
    private Date    gmtModified;
    private Date    gmtCreate;
    private Integer state;

    // Constructors

    /** default constructor */
    public Interview() {
    }

    /** full constructor */
    public Interview(Integer jobseekerId, Integer interviewerId, Integer step, String memo,
                     String orderId, Date gmtModified, Date gmtCreate, Integer state) {
        this.jobseekerId = jobseekerId;
        this.interviewerId = interviewerId;
        this.step = step;
        this.memo = memo;
        this.orderId = orderId;
        this.gmtModified = gmtModified;
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

    public Integer getJobseekerId() {
        return this.jobseekerId;
    }

    public void setJobseekerId(Integer jobseekerId) {
        this.jobseekerId = jobseekerId;
    }

    public Integer getInterviewerId() {
        return this.interviewerId;
    }

    public void setInterviewerId(Integer interviewerId) {
        this.interviewerId = interviewerId;
    }

    public Integer getStep() {
        return this.step;
    }

    public void setStep(Integer step) {
        this.step = step;
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

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}