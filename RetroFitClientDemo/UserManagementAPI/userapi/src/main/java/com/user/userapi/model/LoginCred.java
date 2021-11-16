package com.user.userapi.model;

import org.springframework.lang.NonNull;

public class LoginCred {
	@NonNull
	private String email;
	@NonNull
	private String password;
	public LoginCred() {
		super();
	}
	public LoginCred(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCred [email=" + email + ", password=" + password + "]";
	}
	
	
}
