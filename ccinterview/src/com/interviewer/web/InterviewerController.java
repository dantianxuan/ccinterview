/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.dao.CompanyDAO;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.pojo.Company;
import com.interviewer.pojo.Interviewer;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class InterviewerController {

    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private CompanyDAO     companyDAO;

    @RequestMapping(value = "interviewer/interviewerSelf.htm", method = RequestMethod.GET)
    public ModelAndView interviewerSelf(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("interviewer/interviewerSelf");
        return view;
    }

    @RequestMapping(value = "interviewer/personal.htm", method = RequestMethod.GET)
    public ModelAndView interviewerPage(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("interviewer/personal");
        return view;
    }

    @RequestMapping(value = "interviewer/messages.htm", method = RequestMethod.GET)
    public ModelAndView interviewMessage(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("interviewer/messages");
        return view;
    }

    @RequestMapping(value = "/interviewerInfo.htm", method = RequestMethod.GET)
    public ModelAndView toInterviewerInfo(HttpServletRequest request, String interviewerId,
                                          ModelMap modelMap) {
        int interverId = NumberUtils.toInt(interviewerId);
        Interviewer interviewer = interviewerDAO.findById(interverId);
        Company company = companyDAO.findById(interverId);
        modelMap.put("interviewer", interviewer);
        modelMap.put("company", company);
        ModelAndView view = new ModelAndView("content/interviewerInfo");
        return view;
    }

}
