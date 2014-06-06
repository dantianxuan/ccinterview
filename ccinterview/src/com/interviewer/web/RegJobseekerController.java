/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;

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
     * 注册一个求职者
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regJobseeker.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,ModelMap modelMap){
        ModelAndView view = new ModelAndView("content/regJobseeker");
        return view;
    }

}
