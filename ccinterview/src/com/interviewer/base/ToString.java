/**
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.interviewer.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <pre> ToString基类
 * 
 * 如果作为入参对象继承该类时，请重写toString方法，用于摘要日志打印
 * </pre>
 * @author jingyu.dan
 * @version $Id: ToString.java, v 0.1 2012-11-7 下午8:19:07 jingyu.dan Exp $
 */
public class ToString implements Serializable {

    /** serialVersionUID */
    private static final long     serialVersionUID  = -6332261948136436515L;

    /** 左括号 */
    protected static final String LEFT_PARENTHESIS  = "(";

    /** 右括号 */
    protected static final String RIGHT_PARENTHESIS = ")";

    /** 分隔符-逗号 */
    protected static final String COMMA_SEPARATOR   = ",";

    /** 
     * toString方法重写
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
