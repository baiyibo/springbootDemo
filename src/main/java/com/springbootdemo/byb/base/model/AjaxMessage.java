
package com.springbootdemo.byb.base.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class AjaxMessage implements Serializable {

	private static final long	serialVersionUID	= -7295464290183189928L;

	public static final String	STATUS_SUCCESS		= "success";
	public static final String	STATUS_FAIL			= "fail";
	public static final String	STATUS_ERROR		= "error";
	public static final String	STATUS_WARN			= "warn";

	private String				status;
	private Object				data;
	private String				message;

	public boolean isSuccess() {
		return STATUS_SUCCESS.equals(getStatus());
	}

	/**
	 * @param status
	 */
	public AjaxMessage(String status) {
		super();
		this.status = status;
	}

	public static AjaxMessage success(Object data) {
		AjaxMessage am = new AjaxMessage(STATUS_SUCCESS);
		am.setData(data);
		return am;
	}

	public static AjaxMessage success() {
		AjaxMessage am = new AjaxMessage(STATUS_SUCCESS);
		return am;
	}

	public static AjaxMessage failue(Map<String, String> errors) {
		AjaxMessage am = new AjaxMessage(STATUS_FAIL);
		Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>(1);
		data.put("errors", errors);
		am.setData(data);
		return am;
	}

	public static AjaxMessage error(String message) {
		AjaxMessage am = new AjaxMessage(STATUS_ERROR);
		am.setMessage(message);
		return am;
	}

	public static AjaxMessage warn(String message) {
		AjaxMessage am = new AjaxMessage(STATUS_WARN);
		am.setMessage(message);
		return am;
	}

	public AjaxMessage data(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public AjaxMessage setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public AjaxMessage setData(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public AjaxMessage setMessage(String message) {
		this.message = message;
		return this;
	}

}
