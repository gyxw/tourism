package com.iac.tourism.api.security;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rop.session.Session;
import com.rop.session.SessionManager;

public class LocalSessionController implements SessionManager {

	private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);
	
	@Override
	public void addSession(String sessionId, Session session) {
		sessionCache.putIfAbsent(sessionId, session);
	}

	@Override
	public Session getSession(String sessionId) {
		return sessionCache.get(sessionId);
	}

	@Override
	public void removeSession(String sessionId) {
		sessionCache.remove(sessionId);
	}

}
