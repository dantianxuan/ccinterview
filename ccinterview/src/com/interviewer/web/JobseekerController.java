/**
 * 
 */
package com.interviewer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.enums.DataStateEnum;
import com.interviewer.enums.InterviewStepEnum;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.view.InterviewVO;

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
        ModelAndView view = new ModelAndView("jobseeker/jobseekerSelf");
        final Jobseeker jobseeker = getJobseekerInSession(request.getSession());
        CcResult result = serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                List<InterviewVO> interviewVOs = interviewDAO.findInterviews(jobseeker.getId(),
                    InterviewStepEnum.CREATE, DataStateEnum.NORMAL);
                return new CcResult(interviewVOs);
            }
        });
        modelMap.put("result", result);
        return view;
    }

}
