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

import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class JobseekerController {

    @RequestMapping(value = "/jobseeker/jobseekerSelf.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, ModelMap modelMap) {
        Object jobseeker = request.getSession().getAttribute(CcConstrant.SESSION_JOBSEEKER_OBJECT);
        modelMap.put("result", new CcResult(jobseeker));
        ModelAndView view = new ModelAndView("jobseeker/jobseekerSelf");
        return view;
    }
}
