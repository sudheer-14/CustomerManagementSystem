package com.mainproject.model;

public class Admin {

	private String username;
	private String password;
	public Admin(String email, String password) {
		super();
		this.username = email;
		this.password = password;
	}
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
	
	
}
