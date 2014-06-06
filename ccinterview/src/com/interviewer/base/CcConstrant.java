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
    public final static String TIME_TOKEN                = "TIME_TOKEN";

    /** interviewer对象 */
    public final static String SESSION_NTERVIEWER_OBJECT = "SESSION_NTERVIEWER_OBJECT";

    /** USERINFO 对象 */
    public final static String SESSION_USER_INFO_OBJECT  = "SESSION_USER_INFO_OBJECT";

    /** USERINFO 对象 */
    public final static String UPLOAD_FOLDER             = "UPLOAD_FOLDER";

    /**默认页大小*/
    public final static int    DEFAULT_PAGE_SIZE         = 20;

    public static String getUploadFolder() {
        return UPLOAD_FOLDER;
    }

}
