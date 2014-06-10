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
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Interviewer;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class InterviewController {

    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private CompanyDAO     companyDAO;

    @RequestMapping(value = "jobseeker/createInterview.htm", method = RequestMethod.GET)
    public ModelAndView toInterview(HttpServletRequest request, String interviewerId,
                                    ModelMap modelMap) {
        ModelAndView view = new ModelAndView("jobseeker/createInterview");
        int viewerId = NumberUtils.toInt(interviewerId);
        Interviewer interviewer = interviewerDAO.findById(viewerId);
        Company company = companyDAO.findById(interviewer.getCompanyId());
        modelMap.put("interviewer", interviewer);
        modelMap.put("company", company);
        return view;
    }

    @RequestMapping(value = "jobseeker/createInterview.htm", params = "action=create", method = RequestMethod.POST)
    public ModelAndView createInterview(HttpServletRequest request, Interview interview,
                                        ModelMap modelMap) {
        ModelAndView view = new ModelAndView("jobseeker/createInterview");
        
        return view;
    }

}
