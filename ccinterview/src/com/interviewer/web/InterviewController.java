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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.enums.DataStateEnum;
import com.interviewer.enums.InterviewStepEnum;
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.view.InterviewerVO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class InterviewController extends BaseController {

    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private InterviewDAO   interviewDAO;

    @RequestMapping(value = "jobseeker/createInterview.htm", method = RequestMethod.GET)
    public ModelAndView toInterview(HttpServletRequest request, String interviewerId,
                                    ModelMap modelMap) {
        ModelAndView view = new ModelAndView("jobseeker/createInterview");
        int viewerId = NumberUtils.toInt(interviewerId);
        InterviewerVO interviewerVO = interviewerDAO.findById(viewerId);
        modelMap.put("interviewerVO", interviewerVO);
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
                InterviewerVO interviewerVO = interviewerDAO.findById(interview.getInterviewerId());
                AssertUtil.notNull(interviewerVO, "咨询对象不存在，请检查");
                interview.setGmtCreate(new Date());
                interview.setStep(InterviewStepEnum.CREATE.getValue());
                interview.setGmtModified(new Date());
                interview.setState(DataStateEnum.NORMAL.getValue());
                interviewDAO.save(interview);
                return new CcResult(interview);
            }
        });
        if (result.isSuccess()) {
            return new ModelAndView("redirect:/jobseeker/interview.htm?interviewId="
                                    + interview.getId());
        }
        InterviewerVO interviewerVO = interviewerDAO.findById(interview.getInterviewerId());
        modelMap.put("interviewerVO", interviewerVO);
        modelMap.put("result", result);
        return new ModelAndView("jobseeker/createInterview");
    }

    @RequestMapping(value = "jobseeker/interview.htm")
    public ModelAndView createInterview(final HttpServletRequest request, final String interviewId,
                                        ModelMap modelMap) {
        Interview interview = interviewDAO.findById(NumberUtils.toInt(interviewId));
        modelMap.put("interview", interview);
        InterviewerVO interviewerVO = interviewerDAO.findById(interview.getInterviewerId());
        modelMap.put("interviewerVO", interviewerVO);
        return new ModelAndView("jobseeker/interview");
    }

    @RequestMapping(value = "jobseeker/deleteInterview.json")
    public @ResponseBody
    ModelMap deleteInterview(final HttpServletRequest request, final String interviewId,
                             ModelMap modelMap) {

        CcResult result = serviceTemplate.executeWithTx(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                Interview interview = interviewDAO.findById(NumberUtils.toInt(interviewId));
                interview.setState(DataStateEnum.DELETE.getValue());
                interviewDAO.update(interview);
                return new CcResult(interview);
            }
        });
        modelMap.put("result", result);
        return modelMap;
    }
}
