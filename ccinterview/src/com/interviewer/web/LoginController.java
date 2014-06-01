/**
 * 
 */
package com.interviewer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewerDAO;
import com.interviewer.pojo.Interviewer;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class LoginController {

    @Autowired
    private InterviewerDAO interviewerDAO;

    @RequestMapping(value = "/login.htm", params = "action=INTERVIEWER", method = RequestMethod.POST)
    public ModelAndView loginInterviewer(HttpServletRequest request, String account,
                                         String password, ModelMap modelMap) {

        @SuppressWarnings("unchecked")
        List<Interviewer> interviewers = interviewerDAO.findByEmail(account);
        if (CollectionUtils.isEmpty(interviewers) || interviewers.get(0) == null) {
            modelMap.put("result", new CcResult("用户不存在"));
            return new ModelAndView("content/login");
        }
        if (!StringUtils.equals(interviewers.get(0).getPasswd(), password)) {
            modelMap.put("result", new CcResult("密码错误"));
            return new ModelAndView("content/login");
        }
        request.getSession().setAttribute(CcConstrant.SESSION_NTERVIEWER_OBJECT,
            interviewers.get(0));
        return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public ModelAndView loginUser(HttpServletRequest request, String account, String password,
                                  ModelMap modelMap) {

        return new ModelAndView("content/login");
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView initPage(HttpServletRequest httpservletrequest) {
        ModelAndView view = new ModelAndView("content/login");
        return view;
    }

}
