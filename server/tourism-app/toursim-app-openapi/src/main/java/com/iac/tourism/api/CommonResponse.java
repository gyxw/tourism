package com.iac.tourism.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonResponse {

	private int code = ErrorCode.SUCESS.ordinal();
	private String message;
	public static CommonResponse success() {
		return new CommonResponse();
	}
	public static CommonResponse failure(ErrorCode errorCode, String message) {
		return new CommonResponse(errorCode.ordinal(), message);
	}
	
	public CommonResponse() {
	}
	public CommonResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
