/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.dao.JobseekerDAO;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.view.InterviewerVO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class LoginController {

    @Autowired
    private InterviewerDAO interviewerDAO;

    @Autowired
    private JobseekerDAO   jobseekerDAO;

    @RequestMapping(value = "/login.htm", params = "action=INTERVIEWER", method = RequestMethod.POST)
    public ModelAndView loginInterviewer(HttpServletRequest request, String account,
                                         String password, ModelMap modelMap) {
        InterviewerVO interviewerVO = interviewerDAO.findByEmail(account);
        if (interviewerVO == null) {
            modelMap.put("result", new CcResult("用户不存在"));
            return new ModelAndView("content/login");
        }
        if (!StringUtils.equals(interviewerVO.getInterviewer().getPasswd(), password)) {
            modelMap.put("result", new CcResult("密码错误"));
            return new ModelAndView("content/login");
        }
        request.getSession().setAttribute(CcConstrant.SESSION_INTERVIEWER_OBJECT, interviewerVO);
        return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
    }

    @RequestMapping(value = "/login.htm", params = "action=JOBSEEKER", method = RequestMethod.POST)
    public ModelAndView loginJobseeker(HttpServletRequest request, String account, String password,
                                       ModelMap modelMap) {
        Jobseeker jobseeker = jobseekerDAO.findByEmail(account);
        modelMap.put("account", account);
        if (jobseeker == null) {
            modelMap.put("result", new CcResult("用户不存在"));
            return new ModelAndView("content/login");
        }
        if (!StringUtils.equals(jobseeker.getPasswd(), password)) {
            modelMap.put("result", new CcResult("密码错误"));
            return new ModelAndView("content/login");
        }
        request.getSession().setAttribute(CcConstrant.SESSION_JOBSEEKER_OBJECT, jobseeker);
        return new ModelAndView("redirect:/jobseeker/jobseekerSelf.htm");
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView initPage(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("content/login");
        return view;
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().removeAttribute(CcConstrant.SESSION_INTERVIEWER_OBJECT);
        request.getSession().removeAttribute(CcConstrant.SESSION_JOBSEEKER_OBJECT);
        ModelAndView view = new ModelAndView("redirect:/index.htm");
        return view;
    }

    @RequestMapping(value = "/findPasswd.htm", method = RequestMethod.GET)
    public ModelAndView findPasswd(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("content/findPasswd");
        return view;
    }

}
