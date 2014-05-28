/**
 * 
 */
package com.interviewer.filter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.interviewer.base.CcConstrant;
import com.interviewer.util.LogUtil;

/**
 * 用于系统打印日志
 * 
 * @author jingyu.dan
 * 
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = Logger.getLogger(InterviewerAuthorityInterceptor.class);

    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        LogUtil.info(logger, "接受请求");
        request.getParameterMap().put(CcConstrant.TIME_TOKEN, new Date());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        LogUtil.info(logger, "接受请求");
        request.getParameterMap().put(CcConstrant.TIME_TOKEN, new Date());
    }

}
