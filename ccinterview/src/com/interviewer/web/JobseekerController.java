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
public class JobseekerController extends BaseController {

    @RequestMapping(value = "/jobseeker/jobseekerSelf.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("jobseeker/jobseekerSelf");
        return view;
    }

}
