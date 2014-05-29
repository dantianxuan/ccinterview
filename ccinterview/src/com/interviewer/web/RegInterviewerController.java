/**
 * 
 */
package com.interviewer.web;

import java.util.UUID;

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
import com.interviewer.pojo.RegMail;
import com.interviewer.service.RegistService;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class RegInterviewerController {

    @Autowired
    private RegistService registService;

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/reg_interviewer_init.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,
                                      HttpServletResponse httpservletresponse, ModelMap modelMap)
                                                                                                 throws Exception {
        ModelAndView view = new ModelAndView("regist/reg_interviewer_init");
        return view;
    }

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/reg_interviewer_mail.htm", method = RequestMethod.GET)
    public ModelAndView registMail(HttpServletRequest httpservletrequest, String mail,
                                   ModelMap modelMap) throws Exception {
        ModelAndView view = new ModelAndView("regist/reg_interviewer_init");
        RegMail regMail = new RegMail();
        regMail.setMail(mail);
        regMail.setToken(UUID.randomUUID().toString());
        CcResult result = registService.regMail(regMail);
        modelMap.put("result", result);
        return view;
    }

}
