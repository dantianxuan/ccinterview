/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.enums;

import org.apache.commons.lang.StringUtils;


/**
 * 订单状态枚举
 * 
 * @author jingyu.dan
 * @version $Id: InterviewStateEnum.java, v 0.1 2014-6-10 下午6:06:53 jingyu.dan Exp $
 */
public enum InterviewStateEnum {
    
    /** 创建状态 */
    CREATE("1", "CREATE", "创建状态"),

    /** 已经支付 */
    DERIVED("2", "DERIVED", "衍生数据原子");

    /** 枚举码 */
    private String value;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    /**
     * 私有构造方法
     * @param value         枚举值
     * @param code          枚举code
     * @param description   枚举描述
     */
    private InterviewStateEnum(String value, String code, String description) {
        this.value = value;
        this.code = code;
        this.description = description;
    }

    /**
     * 通过枚举<code>value</code>获得枚举。
     * 
     * @param value 枚举值
     * @return      枚举对象
     */
    public static InterviewStateEnum getByValue(String value) {
        for (InterviewStateEnum type : values()) {
            if (StringUtils.equals(type.getValue(), value)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
}
