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

    /**
     * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 
     * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        Object interviewer = request.getSession().getAttribute(
            CcConstrant.SESSION_NTERVIEWER_OBJECT);
        if (interviewer == null) {
            LogUtil.info(log, "无权限的请求", request.getLocalAddr());
            response.sendRedirect("/ccinterview/login.htm");
            return false;
        }
        log.info("==============执行顺序: 1、preHandle================");
        return true;
    }

}
