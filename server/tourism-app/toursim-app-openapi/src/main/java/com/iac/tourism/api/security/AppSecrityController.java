package com.iac.tourism.api.security;

import java.util.HashMap;
import java.util.Map;

import com.rop.security.AppSecretManager;

public class AppSecrityController implements AppSecretManager {

	private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

    static {
        appKeySecretMap.put("android", "abcdeabcdeabcdeabcdeabcde");
        appKeySecretMap.put("test", "abcdeabcdeabcdeabcdeaaaaa");
    }

	
	@Override
	public String getSecret(String appKey) {
		return appKeySecretMap.get(appKey);
	}

	@Override
	public boolean isValidAppKey(String appKey) {
		return getSecret(appKey) != null;
	}

}
