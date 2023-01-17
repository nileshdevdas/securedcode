package com.vinsys.security.helpers;

public class ValidationHelper {
	public static boolean isNullOrEmpty(String value) {
		return (value == null) || (value.trim().equals("")) || value.trim().equals("null");
	}

	public static boolean isNullOrEmpty(Object value) {
		return (value == null);
	}

	public static boolean isNotNegative(Long value) {
		return value == 0;
	}

}
