package com.iac.tourism.api.user;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.rop.AbstractRopRequest;

/**
 * 登录请求
 * @author iacdp
 *
 */
public class LoginForm extends AbstractRopRequest {

	@NotBlank
	@Pattern(regexp="\\w{6,20}")
	private String username;
	@NotBlank
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
