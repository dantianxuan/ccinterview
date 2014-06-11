/**
 * 
 */
package com.interviewer.base;

/**
 * 
 * @author jingyu.dan
 * 
 */
public class CcConstrant {

    /** 用于统计处理时间的时间key */
    public final static String TIME_TOKEN                 = "TIME_TOKEN";

    /** interviewer对象 */
    public final static String SESSION_INTERVIEWER_OBJECT = "SESSION_INTERVIEWER_OBJECT";

    /** USERINFO 对象 */
    public final static String SESSION_JOBSEEKER_OBJECT   = "SESSION_JOBSEEKER_OBJECT";

    /** USERINFO 对象 */
    public final static String UPLOAD_FOLDER              = "UPLOAD_FOLDER";

    /**短消息字符长度*/
    public final static int    SHOT_MESSAGE_LENGTH        = 512;

    /**默认页大小*/
    public final static int    DEFAULT_PAGE_SIZE          = 20;

    public static String getUploadFolder() {
        return UPLOAD_FOLDER;
    }

}
