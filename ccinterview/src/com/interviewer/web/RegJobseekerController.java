/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class RegJobseekerController {

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jobseeker/reg_jobseeker.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,
                                      HttpServletResponse httpservletresponse, ModelMap modelMap)
                                                                                                 throws Exception {
        ModelAndView view = new ModelAndView("jobseeker/reg_jobseeker");
        return view;
    }

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jobseeker/reg_jobseeker_submit.htm", method = RequestMethod.GET)
    public ModelAndView registMail(HttpServletRequest httpservletrequest, String mail,
                                   ModelMap modelMap) throws Exception {
        ModelAndView view = new ModelAndView("jobseeker/reg_jobseeker");
        return view;
    }

}
