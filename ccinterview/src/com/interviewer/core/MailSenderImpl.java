/**
 * 
 */
package com.interviewer.core;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.interviewer.base.CcException;

/**
 * @author jingyu.dan
 * 
 */
public class MailSenderImpl implements MailSender {

    /** 发送邮件 */
    @Autowired
    private JavaMailSender      javaMailSender;

    private final static String mainHtml = "";

    /*
     * (non-Javadoc)
     * 
     * @see com.interviewer.mail.MailSender#sendMail(java.lang.String)
     */
    @Override
    public void sendMail(String email, String mailText) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
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
        } catch (Exception e) {
            throw new CcException(e, "邮件发送失败");
        }
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

}
