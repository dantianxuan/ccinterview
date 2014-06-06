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
	public ModelAndView loginInterviewer(HttpServletRequest request,
			String account, String password, ModelMap modelMap) {
		Interviewer interviewer = interviewerDAO.findByEmail(account);
		if (interviewer == null) {
			modelMap.put("result", new CcResult("用户不存在"));
			return new ModelAndView("content/login");
		}
		if (!StringUtils.equals(interviewer.getPasswd(), password)) {
			modelMap.put("result", new CcResult("密码错误"));
			return new ModelAndView("content/login");
		}
		request.getSession().setAttribute(
				CcConstrant.SESSION_NTERVIEWER_OBJECT, interviewer);
		return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, String account,
			String password, ModelMap modelMap) {

		return new ModelAndView("content/login");
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView initPage(HttpServletRequest request, ModelMap modelMap) {
		ModelAndView view = new ModelAndView("content/login");
		return view;
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute(
				CcConstrant.SESSION_NTERVIEWER_OBJECT);
		request.getSession().removeAttribute(
				CcConstrant.SESSION_USER_INFO_OBJECT);
		ModelAndView view = new ModelAndView("redirect:/index.htm");
		return view;
	}

	@RequestMapping(value = "/findPasswd.htm", method = RequestMethod.GET)
	public ModelAndView findPasswd(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("content/findPasswd");
		return view;
	}

}
