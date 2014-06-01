/**
 * 
 */
package com.interviewer.web;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.pojo.Interviewer;
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

    //@Autowired
    // private QueryCompanyService queryCompanyService;

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewerInit.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("regist/regInterviewerInit");
        return view;
    }

    /**
     * 使用公司邮箱进行注册
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewerMail.htm", method = RequestMethod.GET)
    public ModelAndView registMail(HttpServletRequest httpservletrequest, String email,
                                   String subPrefix, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("regist/regInterviewerInit");
        RegMail regMail = new RegMail();
        regMail.setMail(email + subPrefix);
        regMail.setGmtCreate(new Date());
        regMail.setToken(UUID.randomUUID().toString());
        CcResult result = registService.regMail(regMail);
        modelMap.put("result", result);
        return view;
    }

    /**
     * 公司邮箱链接注册
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewer.htm", method = RequestMethod.GET)
    public ModelAndView initRegInterviewer(String token, ModelMap modelMap) {
        CcResult result = registService.getRegMainInfo(token);
        if (!result.isSuccess()) {
            modelMap.put("result", result);
            return new ModelAndView("regist/regInterviewerInit");
        }
        modelMap.put("result", result);
        Interviewer interviewer = new Interviewer();
        interviewer.setEmail(((RegMail) result.getObject()).getMail());
        modelMap.put("interviewer", interviewer);
        modelMap.put("regMailId", ((RegMail) result.getObject()).getId());
        return new ModelAndView("regist/regInterviewer");
    }

    /**
     * 公司邮箱链接注册
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewer.htm", params = "action=regist")
    public ModelAndView submitRegInterviewer(HttpServletRequest request, Interviewer interviewer,
                                             String regMailId, ModelMap modelMap) {
        interviewer.setGmtCreate(new Date());
        interviewer.setGmtModified(new Date());
        CcResult result = registService.regInterviewer(interviewer, NumberUtils.toInt(regMailId));
        if (result.isSuccess()) {
            request.getSession().setAttribute(CcConstrant.SESSION_NTERVIEWER_OBJECT,
                result.getObject());
            return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
        }
        modelMap.put("result", result);
        modelMap.put("regMailId", regMailId);
        modelMap.put("interviewer", interviewer);
        return new ModelAndView("regist/regInterviewer");
    }
}
