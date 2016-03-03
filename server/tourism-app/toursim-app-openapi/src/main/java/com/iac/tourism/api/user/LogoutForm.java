package com.iac.tourism.api.user;

import com.rop.AbstractRopRequest;

public class LogoutForm extends AbstractRopRequest {

	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
