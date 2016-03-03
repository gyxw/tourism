package com.iac.util.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springside.modules.utils.Exceptions;

/**
 * Utils - Web
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
public final class WebUtils {

	// 通过前端的负载均衡服务器时，请求对象中的IP会变成负载均衡服务器的IP，因此需要特殊处理，下同。
	public static final String X_REAL_IP = "X-Real-IP";
	public static final String X_FORWARDED_FOR = "X-Forwarded-For";

	/**
	 * 不可实例化
	 */
	private WebUtils() {
	}

	public static void addCookie(HttpServletRequest request, 
			HttpServletResponse response, String name, String value,
			Integer maxAge, String path, String domain, Boolean secure) {
		Assert.notNull(request);
		Assert.notNull(response);
		Assert.hasText(name);
		try {
			name = URLEncoder.encode(name, "UTF-8");
			value = URLEncoder.encode(value, "UTF-8");
			Cookie cookie = new Cookie(name, value);
			if (maxAge != null) {
				cookie.setMaxAge(maxAge);
			}
			if (StringUtils.isNotEmpty(path)) {
				cookie.setPath(path);
			}
			if (StringUtils.isNotEmpty(domain)) {
				cookie.setDomain(domain);
			}
			if (secure != null) {
				cookie.setSecure(secure);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			throw Exceptions.unchecked(e);
		}
	}

	/**
	 * 添加cookie
	 * @param maxAge 有效期(单位: 秒)
	 */
	public static void addCookie(HttpServletRequest request, 
			HttpServletResponse response, String name, String value,
			Integer maxAge) {
		addCookie(request, response, name, value, maxAge, "/", null, null);
	}

	/**
	 * 添加cookie
	 */
	public static void addCookie(HttpServletRequest request, 
			HttpServletResponse response, String name, String value) {
		addCookie(request, response, name, value, null, "/", null, null);
	}

	/**
	 * 获取cookie
	 * 
	 * @return 若不存在则返回null
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		Assert.notNull(request);
		Assert.hasText(name);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			try {
				name = URLEncoder.encode(name, "UTF-8");
				for (Cookie cookie : cookies) {
					if (name.equals(cookie.getName())) {
						return URLDecoder.decode(cookie.getValue(), "UTF-8");
					}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 移除cookie
	 */
	public static void removeCookie(HttpServletRequest request, 
			HttpServletResponse response, String name, String path,
			String domain) {
		Assert.notNull(request);
		Assert.notNull(response);
		Assert.hasText(name);
		try {
			name = URLEncoder.encode(name, "UTF-8");
			Cookie cookie = new Cookie(name, null);
			cookie.setMaxAge(0);
			if (StringUtils.isNotEmpty(path)) {
				cookie.setPath(path);
			}
			if (StringUtils.isNotEmpty(domain)) {
				cookie.setDomain(domain);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 移除cookie
	 */
	public static void removeCookie(HttpServletRequest request, 
			HttpServletResponse response, String name) {
		removeCookie(request, response, name, "/", null);
	}

	/**
	 * 获取远程访问IP 前段有负载均衡时获取负载服务转发后的IP地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteIp = request.getHeader(X_REAL_IP); // nginx反向代理
		if (StringUtils.isNotBlank(remoteIp)) {
			return remoteIp;
		} else {
			remoteIp = request.getHeader(X_FORWARDED_FOR);// apache反射代理
			if (StringUtils.isNotBlank(remoteIp)) {
				String[] ips = remoteIp.split(",");
				for (String ip : ips) {
					if (!"null".equalsIgnoreCase(ip)) {
						return ip;
					}
				}
			}
			return request.getRemoteAddr();
		}
	}

	/**
	 * 获取相对地址与参数
	 * @return example /activity?from=llgj return /activity
	 * @throws IOException
	 */
	public static String getRelativeUrl(HttpServletRequest request) {
		String result = request.getRequestURI().substring(request.getContextPath().length());
		int index = result.indexOf(";");
		if (index != -1) {
			result = result.substring(0, index);
		}
		return result;
	}

	/**
	 * 获取访问全地址 不包括参数
	 * @return example http://3g.k189.cn:8100/flow-service-wap/index
	 */
	public static String getCompleteUrl(HttpServletRequest request) {
		return getDomainUrl(request) + request.getRequestURI();
	}

	public static String getDomainUrl(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName()
				+ (request.getServerPort() == 80 ? "" : ":" + request.getServerPort());
	}

	/**
	 * 获取 http://域名：端口/context
	 * @return example http://3g.k189.cn:8100/flow-service-assets-query
	 */
	public static String getRequestContext(HttpServletRequest request) {
		return getDomainUrl(request) + request.getContextPath();
	}
}