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

import com.interviewer.base.CcConstrant;
import com.interviewer.dao.ArticleDAO;
import com.interviewer.dao.CompanyDAO;
import com.interviewer.pojo.Article;
import com.interviewer.pojo.Company;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class IndexController {

    private final static int TOPX = 16;

    @Autowired
    private ArticleDAO       articleDAO;
    @Autowired
    private CompanyDAO       companyDAO;

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView toIndex(HttpServletRequest request, ModelMap modelMap) {
        List<Article> articles = articleDAO.findRecentList(TOPX);
        List<Company> companys = companyDAO.findHotList(TOPX);
        modelMap.put("articles", articles);
        modelMap.put("companys", companys);
        ModelAndView view = new ModelAndView("content/index");
        return view;
    }

    @RequestMapping(value = "/mySelf.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, ModelMap modelMap) {
        Object jobseeker = request.getSession().getAttribute(CcConstrant.SESSION_JOBSEEKER_OBJECT);
        if (jobseeker != null) {
            return new ModelAndView("redirect:/jobseeker/jobseekerSelf.htm");
        }
        Object interviewer = request.getSession().getAttribute(
            CcConstrant.SESSION_NTERVIEWER_OBJECT);
        if (interviewer != null) {
            return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
        }
        ModelAndView view = new ModelAndView("content/login");
        return view;
    }

}
