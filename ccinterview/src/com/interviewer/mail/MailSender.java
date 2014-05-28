/**
 * 
 */
package com.interviewer.mail;

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
    public boolean sendMail(String email, String mailText);
}
