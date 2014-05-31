/**
 * 
 */
package com.interviewer.core;

import com.interviewer.pojo.RegMail;

/**
 * @author jingyu.dan
 * 
 */
public interface MailSender {

    /**
     * 发送mail
     * 
     * @param mailText
     */
    public void sendMail(RegMail regMail);
}
