/**
 * 
 */
package com.interviewer.base;

/**
 * 同意处理结果
 * 
 * @author jingyu.dan
 * 
 */
public class CcResult extends ToString {

	/** serialVersionUID */
	private static final long serialVersionUID = 4887277624451526447L;

	/** 成功标识 */
	private boolean success = false;

	/** 结果码 */
	private String code = "UNKNOWN";

	/** 返回信息 */
	private String message = "未知异常";

	/** 单次服务请求唯一标识 */
	protected String token;

	/**
	 * 同意处理结果
	 */
	public CcResult() {

	}

	public static CcResult retSuccess() {
		CcResult result = new CcResult();
		result.success = true;
		result.message = "处理成功";
		result.code = "SUCCESS";
		return result;
	}

	/**
	 * 取得是否成功标识
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Setter method for property <tt>token</tt>.
	 * 
	 * @param token
	 *            value to be assigned to property token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
