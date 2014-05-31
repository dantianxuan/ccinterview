/**
 * 
 */
package com.interviewer.web;

import java.util.Date;
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
import com.interviewer.pojo.RegMail;
import com.interviewer.query.QueryCompanyService;
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
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest, String token,
                                      ModelMap modelMap) {
        CcResult result = registService.getRegMainInfo(token);
        if (!result.isSuccess()) {
            modelMap.put("result", result);
            return new ModelAndView("regist/regInterviewerInit");
        }
        modelMap.put("result", result);
        return new ModelAndView("regist/regInterviewer");
    }
}
