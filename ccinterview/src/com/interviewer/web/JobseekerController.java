/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class JobseekerController extends BaseController {

    @Autowired
    private InterviewDAO interviewDAO;

    @RequestMapping(value = "/jobseeker/jobseekerSelf.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, ModelMap modelMap) {

        interviewDAO.findById(id);
        ModelAndView view = new ModelAndView("jobseeker/jobseekerSelf");
        return view;
    }

}
