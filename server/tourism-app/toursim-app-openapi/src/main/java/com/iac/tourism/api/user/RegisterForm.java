package com.iac.tourism.api.user;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.rop.AbstractRopRequest;

/**
 * 注册验证
 * @author Markin
 *
 */
public class RegisterForm extends AbstractRopRequest {

	@NotBlank
	@Pattern(regexp="[\\W|\\d]{3,15}")
	private String username;
	@NotBlank
	@Pattern(regexp="[\\W|\\d]{6, 20}")
	private String password;
	@NotBlank
	@Pattern(regexp="1[0-9]{10}")
	private String mobile;
	
	/**
	 * may be 4 or 6 numbers
	 */
	@NotBlank
	@Pattern(regexp="[0-9]{4,6}")
	private String captchas;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCaptchas() {
		return captchas;
	}
	public void setCaptchas(String captchas) {
		this.captchas = captchas;
	}
}
