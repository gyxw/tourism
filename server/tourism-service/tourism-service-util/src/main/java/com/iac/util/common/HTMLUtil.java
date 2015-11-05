package com.iac.util.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML工具
 * 
 */
public class HTMLUtil {

	// >
	public static final String GT = "&gt;";
	// <
	public static final String LT = "&lt;";
	// "
	public static final String QUOT = "&quot;";
	// &
	public static final String AMP = "&amp;";
	// 空格
	public static final String SPACE = "&nbsp;";
	// ©
	public static final String COPYRIGHT = "&copy;";
	// ®
	public static final String REG = "&reg;";
	// ™
	public static final String TM = "&trade;";
	// ¥
	public static final String RMB = "&yen;";

	private static final String REGEX_SCRIPT = "<script[^>]*?>[\\s\\S]*?<\\/script>";
	private static final Pattern P_SCRIPT = Pattern.compile(REGEX_SCRIPT,
			Pattern.CASE_INSENSITIVE);
	
	private static final String REGEX_STYLE = "<style[^>]*?>[\\s\\S]*?<\\/style>";
	private static final Pattern P_STYLE = Pattern
			.compile(REGEX_STYLE, Pattern.CASE_INSENSITIVE);
	
	private static final String REGEX_HTML = "<[^>]+>";
	private static final Pattern P_HTML = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
	
	/**
	 * 删除script标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delScriptTag(String str) {
		Matcher m_script = P_SCRIPT.matcher(str);
		str = m_script.replaceAll("");
		return str.trim();
	}

	/**
	 * 删除style标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delStyleTag(String str) {
		Matcher m_style = P_STYLE.matcher(str);
		str = m_style.replaceAll("");
		return str;
	}

	/**
	 * 删除HTML标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delHTMLTag(String str) {
		Matcher m_html = P_HTML.matcher(str);
		str = m_html.replaceAll("");
		return str;
	}

	/**
	 * 删除所有标签
	 * 
	 * @param str
	 * @return
	 */
	public static String delAllTag(String str) {
		// 删script
		str = delScriptTag(str);
		// 删style
		str = delStyleTag(str);
		// 删HTML
		str = delHTMLTag(str);
		return str;
	}

	/**
	 * 清除标签,恢复HTML转义字符
	 * 
	 * @param str
	 * @return
	 */
	public static String clean(String str) {
		str = delAllTag(str);
		str = str.replaceAll(SPACE, " ");
		str = str.replaceAll(GT, ">");
		str = str.replaceAll(LT, "<");
		str = str.replaceAll(QUOT, "\"");
		str = str.replaceAll(AMP, "&");
		str = str.replaceAll(COPYRIGHT, "©");
		str = str.replaceAll(REG, "®");
		str = str.replaceAll(TM, "™");
		str = str.replaceAll(RMB, "¥");
		return str;
	}

	/**
	 * 过滤指定标签
	 * 
	 * @param str
	 * @param tag
	 *            指定标签
	 * @return String
	 */
	public static String fiterHtmlTag(String str, String tag) {
		String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 替换指定的标签
	 * 
	 * @param str
	 * @param beforeTag
	 *            要替换的标签
	 * @param tagAttrib
	 *            要替换的标签属性值
	 * @param startTag
	 *            新标签开始标记
	 * @param endTag
	 *            新标签结束标记
	 * @return String example: 替换img标签的src属性值为[img]属性值[/img]
	 */
	public static String replaceHtmlTag(String str, String beforeTag,
			String tagAttrib, String startTag, String endTag) {
		String regxpForTag = "<\\s*" + beforeTag + "\\s+([^>]*)\\s*>";
		String regxpForTagAttrib = tagAttrib + "=\"([^\"]+)\"";
		Pattern patternForTag = Pattern.compile(regxpForTag);
		Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib);
		Matcher matcherForTag = patternForTag.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = matcherForTag.find();
		while (result) {
			StringBuffer sbreplace = new StringBuffer();
			Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag
					.group(1));
			if (matcherForAttrib.find()) {
				matcherForAttrib.appendReplacement(sbreplace, startTag
						+ matcherForAttrib.group(1) + endTag);
			}
			matcherForTag.appendReplacement(sb, sbreplace.toString());
			result = matcherForTag.find();
		}
		matcherForTag.appendTail(sb);
		return sb.toString();
	}

	public static void main(String[] args) {
	}

}
