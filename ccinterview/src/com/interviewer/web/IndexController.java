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

import com.interviewer.dao.ArticleDAO;
import com.interviewer.dao.CompanyDAO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
@RequestMapping("/index.htm")
public class IndexController {

    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest, ModelMap modelMap) {
        
        List articles = articleDAO.findAll();
        List companys = companyDAO.findAll();
        modelMap.put("articles", articles);
        modelMap.put("companys", companys);
        ModelAndView view = new ModelAndView("content/index");
        return view;
    }
}
