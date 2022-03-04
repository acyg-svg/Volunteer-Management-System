package com.tool;


public class SaveUserStateTool {
	private static String username = null;
	private static String password = null;

	public static void setUsername(String username) {
		SaveUserStateTool.username = username;
	}

	public static String getUsername() {
		return username;
	}

	public static void setPassword(String password) {
		SaveUserStateTool.password = password;
	}

	public static String getPassword() {
		return password;
	}

}
