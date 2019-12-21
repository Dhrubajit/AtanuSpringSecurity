package com.atanu.java.springboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		boolean bool = Boolean.FALSE;
		if (null == s) {
			bool = Boolean.TRUE;
		} else {
			String pattern = "\\s";
			if (s.matches(pattern)) {
				bool = Boolean.TRUE;
			}
		}
		return bool;
	}

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	/**
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean isEqual(String s1, String s2) {
		boolean bool = Boolean.FALSE;
		if (null != s1 && null != s2) {
			if (s1.equals(s2)) {
				bool = Boolean.TRUE;
			}
		}
		return bool;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean isEqualIgnoreCase(String s1, String s2) {
		boolean bool = Boolean.FALSE;
		if (null != s1 && null != s2) {
			if (s1.equalsIgnoreCase(s2)) {
				bool = Boolean.TRUE;
			}
		}
		return bool;
	}

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isDecimal(String s) {
		boolean bool = Boolean.FALSE;
		String pattern = "^[-+]?\\d+(\\.\\d+)?$";
		if (isNotEmpty(s)) {
			bool = s.matches(pattern);
		}
		return bool;
	}

	/**
	 * @param s
	 * @return boolean
	 */
	public static boolean isNumeric(String s) {
		boolean bool = Boolean.FALSE;
		String pattern = "[0-9]{1,}";
		if (isNotEmpty(s)) {
			bool = s.matches(pattern);
		}
		return bool;
	}

	/**
	 * @param str
	 * @return boolean
	 */
	public static String[] splitByComma(String str) {
		String[] values = str.split(",");
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i].trim();
		}
		return values;
	}

	/**
	 * @param string
	 * @return boolean
	 */
	public static String extractNumber(String string) {
		StringBuffer strBuffer = new StringBuffer();
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			strBuffer.append(matcher.group());
		}
		return strBuffer.toString();
	}

	/**
	 * @param string
	 * @return boolean
	 */
	public static String extractWord(String string) {
		StringBuffer strBuffer = new StringBuffer();
		String regex = "[a-zA-Z]+\\.?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			strBuffer.append(matcher.group());
		}
		return strBuffer.toString();
	}
}
