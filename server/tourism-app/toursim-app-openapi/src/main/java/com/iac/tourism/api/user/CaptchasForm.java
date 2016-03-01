package com.iac.tourism.api.user;

import com.rop.AbstractRopRequest;

/**
 * 手机号 or 邮箱 验证码请求
 * @author iacdp
 *
 */
public class CaptchasForm extends AbstractRopRequest {

	private String mobile;
	private String email;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
