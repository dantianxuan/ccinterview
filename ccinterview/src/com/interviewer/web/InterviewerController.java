/**
 * 
 */
package com.interviewer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.enums.DataStateEnum;
import com.interviewer.enums.InterviewStepEnum;
import com.interviewer.view.InterviewVO;
import com.interviewer.view.InterviewerVO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class InterviewerController extends BaseController {
    @Autowired
    private InterviewerDAO interviewerDAO;
    @Autowired
    private InterviewDAO   interviewDAO;

    @RequestMapping(value = "interviewer/interviewerSelf.htm", method = RequestMethod.GET)
    public ModelAndView interviewerSelf(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("interviewer/interviewerSelf");
        final InterviewerVO interviewerVO = getInterviewerInSession(request.getSession());
        CcResult result = serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                List<InterviewVO> interviewVOs = interviewDAO.findInterviewsByInterviewer(
                    interviewerVO.getInterviewer().getId(), InterviewStepEnum.CREATE,
                    DataStateEnum.NORMAL);
                return new CcResult(interviewVOs);
            }
        });
        modelMap.put("result", result);
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
        InterviewerVO interviewerVO = interviewerDAO.findById(interverId);
        modelMap.put("interviewerVO", interviewerVO);
        ModelAndView view = new ModelAndView("content/interviewerInfo");
        return view;
    }

}
