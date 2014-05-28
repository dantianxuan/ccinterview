/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jingyu.dan
 * 
 */
@Controller
@RequestMapping("/index.htm")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest,
                                      HttpServletResponse httpservletresponse, ModelMap modelMap)
                                                                                                 throws Exception {
        ModelAndView view = new ModelAndView("content/index");
        return view;
    }
}
