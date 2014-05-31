/**
 * 
 */
package com.interviewer.core;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.interviewer.base.CcException;
import com.interviewer.pojo.RegMail;

/**
 * @author jingyu.dan
 * 
 */
public class MailSenderImpl implements MailSender {

    /** 发送邮件 */
    @Autowired
    private JavaMailSender javaMailSender;

    /*
     * (non-Javadoc)
     * 
     * @see com.interviewer.mail.MailSender#sendMail(java.lang.String)
     */
    @Override
    public void sendMail(RegMail regMail) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {
            // 设置utf-8或GBK编码，否则邮件会有乱码
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
            messageHelper.setTo(regMail.getMail());// 接受者
            messageHelper.setFrom("dantianxuan@163.com");// 发送者
            messageHelper.setSubject("测试邮件");// 主题
            // 邮件内容，注意加参数true，表示启用html格式
            String link = "http://localhost:8080/ccinterview/regist/regInterviewer.htm?token="
                          + regMail.getToken();
            messageHelper.setText(
                "<html><head></head><body><h1>欢迎注册成为面试官，请使用如下链接完成注册！<br/>" + "<a href=" + link
                        + ">" + link + "</a>" + "</h1></body></html>", true);
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            throw new CcException(e, "邮件发送失败");
        }
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

}
