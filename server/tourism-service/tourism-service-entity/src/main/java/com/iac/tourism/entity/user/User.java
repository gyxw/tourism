package com.iac.tourism.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.iac.tourism.entity.IdEntity;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * * 用户
 */
@Entity
@Table(name = "c_user")
public class User extends IdEntity {
	
	private static final long serialVersionUID = -5721286389242198770L;
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * loginName       db_column: login_name 
     */ 	
	@NotBlank @Length(max=20)
	private java.lang.String loginName;
    /**
     * password       db_column: password 
     */ 	
	@NotBlank @Length(max=100)
	private java.lang.String password;
    /**
     * salt       db_column: salt 
     */ 	
	@Length(max=45)
	private java.lang.String salt;
    /**
     * mobile       db_column: mobile 
     */ 	
	@Length(max=18)
	private java.lang.String mobile;
    /**
     * sex       db_column: sex 
     */ 	
	private java.lang.Boolean sex;
    /**
     * nickName       db_column: nick_name 
     */ 	
	@Length(max=45)
	private java.lang.String nickName;
	//columns END

	@Column(name = "login_name")
	public java.lang.String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}
	
	@Column(name = "password")
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	@Column(name = "salt")
	public java.lang.String getSalt() {
		return this.salt;
	}
	
	public void setSalt(java.lang.String value) {
		this.salt = value;
	}
	
	@Column(name = "mobile")
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	@Column(name = "sex")
	public java.lang.Boolean getSex() {
		return this.sex;
	}
	
	public void setSex(java.lang.Boolean value) {
		this.sex = value;
	}
	
	@Column(name = "nick_name")
	public java.lang.String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
}

