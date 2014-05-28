/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.CcResult;
import com.interviewer.mail.MailSender;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class RegInterviewerController {

    /** mailsender */
    @Autowired
    private MailSender mailSender;

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/interviewer/reg_interviewer_init.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,
                                      HttpServletResponse httpservletresponse, ModelMap modelMap)
                                                                                                 throws Exception {
        ModelAndView view = new ModelAndView("interviewer/reg_interviewer_init");
        return view;
    }

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/interviewer/reg_interviewer_mail.htm", method = RequestMethod.GET)
    public ModelAndView registMail(HttpServletRequest httpservletrequest, String mail,
                                   ModelMap modelMap) throws Exception {
        ModelAndView view = new ModelAndView("interviewer/reg_interviewer_init");
        boolean isSuccess = mailSender.sendMail(mail, "hello ");
        if (isSuccess) {
            modelMap.put("result", CcResult.retSuccess());
        } else {
            modelMap.put("result", new CcResult());
        }
        return view;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

}
