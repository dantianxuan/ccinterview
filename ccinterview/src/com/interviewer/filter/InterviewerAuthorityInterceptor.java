/**
 * 
 */
package com.interviewer.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.interviewer.base.CcConstrant;
import com.interviewer.util.LogUtil;

/**
 * @author jingyu.dan
 * 
 */
public class InterviewerAuthorityInterceptor extends HandlerInterceptorAdapter {
    private Logger log = Logger.getLogger(InterviewerAuthorityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        Object interviewerVO = request.getSession().getAttribute(
            CcConstrant.SESSION_INTERVIEWER_OBJECT);
        if (interviewerVO == null) {
            LogUtil.info(log, "无权限的请求", request.getLocalAddr());
            response.sendRedirect("/ccinterview/login.htm");
            return false;
        }
        return true;
    }

}
