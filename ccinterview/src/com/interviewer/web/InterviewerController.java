/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class InterviewerController {

    @RequestMapping(value = "/interviewer/interviewerSelf.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,
                                      HttpSession httpSession, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("interviewer/interviewerSelf");
        return view;
    }
}
