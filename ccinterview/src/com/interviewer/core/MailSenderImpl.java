/**
 * 
 */
package com.interviewer.core;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author jingyu.dan
 * 
 */
public class MailSenderImpl implements MailSender {

    /** logger **/
    private Logger         logger = Logger.getLogger(MailSenderImpl.class);
    /** 发送邮件 */
    @Autowired
    private JavaMailSender javaMailSender;

    /*
     * (non-Javadoc)
     * 
     * @see com.interviewer.mail.MailSender#sendMail(java.lang.String)
     */
    @Override
    public boolean sendMail(String email, String mailText) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        boolean isSuccess = false;
        try {
            // 设置utf-8或GBK编码，否则邮件会有乱码
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
            messageHelper.setTo(email);// 接受者
            messageHelper.setFrom("dantianxuan@163.com");// 发送者
            messageHelper.setSubject("测试邮件");// 主题
            // 邮件内容，注意加参数true，表示启用html格式
            messageHelper.setText(
                "<html><head></head><body><h1>hello!!chao.wang</h1></body></html>", true);
            javaMailSender.send(mailMessage);
            isSuccess = true;
        } catch (Exception e) {
            logger.info("xxx", e);
        }
        return isSuccess;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

}
