/**
 * 
 */
package com.interviewer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jingyu.dan
 * 
 */
@Controller
@RequestMapping("/login.htm")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest) {
        ModelAndView view = new ModelAndView("content/login");
        return view;
    }
}
