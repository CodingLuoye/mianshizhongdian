package com.self.lockone;

/**
 * 用户信息
 * @author Administrator
 *
 */
public class Userinfo {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userinfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Userinfo() {
		super();
	}
	
}
