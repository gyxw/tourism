package com.iac.tourism.api.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.iac.tourism.api.CommonResponse;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponse extends CommonResponse {

	@XmlAttribute
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
