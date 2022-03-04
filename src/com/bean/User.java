package com.bean;

public class User {
	private String name = null;
	private String pwd = null;
	private String okPwd = null;

	public User() {
		super();
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User(String name, String pwd, String okPwd) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.okPwd = okPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setOkPwd(String okPwd) {
		this.okPwd = okPwd;
	}

	public String getOkPwd() {
		return okPwd;
	}

	@Override
	public String toString() {
		String str = "User [name=" + name + ",pwd=" + pwd + ",okPwd=" + okPwd + "]";
		return str;
	}

}
