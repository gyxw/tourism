package com.iac.tourism.api.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.iac.tourism.entity.user.User;
import com.rop.AbstractRopRequest;

public class OpenLoginForm extends AbstractRopRequest {

	@NotNull
	private User.Type userType;
	@NotBlank
	private String openId;

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public User.Type getUserType() {
		return userType;
	}
	public void setUserType(User.Type userType) {
		this.userType = userType;
	}
}
