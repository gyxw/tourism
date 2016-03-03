package com.iac.tourism.rop;

import com.iac.tourism.entity.user.User;
import com.rop.session.AbstractSession;

public class OpenSession extends AbstractSession {

	public static final String OPEN_ID_KEY = "OPEN_ID";
	public static final String USER_KEY = "OPEN_SESSION_USER";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5564787493321309240L;

	private String uuid; 
	private User user;
	private Type type;
	private long login_timestamp = System.currentTimeMillis();
	
	public OpenSession() {
		super();
	}

	public OpenSession(String uuid, Type type, User user) {
		super();
		this.type = type;
		this.uuid = uuid;
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public long getLogin_timestamp() {
		return login_timestamp;
	}

	public void setLogin_timestamp(long login_timestamp) {
		this.login_timestamp = login_timestamp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public enum Type {
		THIRD_PLATFORM, APP_LOGIN, OPEN_LOGIN ;
	}
}
