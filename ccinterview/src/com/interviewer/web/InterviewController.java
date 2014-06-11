/**
 * 
 */
package com.interviewer.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.dao.CompanyDAO;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.enums.InterviewStateEnum;
import com.interviewer.pojo.Company;
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.Jobseeker;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class InterviewController extends BaseController {

    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private CompanyDAO     companyDAO;
    @Autowired
    private InterviewDAO   interviewDAO;

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

    @RequestMapping(value = "jobseeker/createInterview.htm", method = RequestMethod.POST)
    public ModelAndView createInterview(final HttpServletRequest request,
                                        final Interview interview, ModelMap modelMap) {
        CcResult result = serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                Jobseeker jobseeker = getJobseekerInSession(request.getSession());
                AssertUtil.notNull(jobseeker, "不合法的用户");
                Interviewer interviewer = interviewerDAO.findById(interview.getInterviewerId());
                AssertUtil.notNull(interviewer, "咨询对象不存在，请检查");

                interview.setGmtCreate(new Date());
                interview.setStep((short) InterviewStateEnum.CREATE.getValue());
                interview.setGmtModified(new Date());
                interviewDAO.save(interview);
                return new CcResult(interview);
            }
        });
        if (result.isSuccess()) {
            return new ModelAndView("redirect:/jobseeker/interview.htm?interviewId="
                                    + interview.getId());
        }
        Interviewer interviewer = interviewerDAO.findById(interview.getInterviewerId());
        Company company = companyDAO.findById(interviewer.getCompanyId());
        modelMap.put("interviewer", interviewer);
        modelMap.put("company", company);
        modelMap.put("result", result);
        return new ModelAndView("jobseeker/createInterview");
    }

    @RequestMapping(value = "jobseeker/interview.htm")
    public ModelAndView createInterview(final HttpServletRequest request, final String interviewId,
                                        ModelMap modelMap) {
        Interview interview = interviewDAO.findById(NumberUtils.toInt(interviewId));
        modelMap.put("interview", interview);
        Interviewer interviewer = interviewerDAO.findById(interview.getInterviewerId());
        Company company = companyDAO.findById(interviewer.getCompanyId());
        modelMap.put("interviewer", interviewer);
        modelMap.put("company", company);
        return new ModelAndView("jobseeker/interview");
    }

}
