package com.sample.app1.sec;

public class LoginUserResponse {
	private String token;
	private String message;
	private User user;
	public LoginUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUserResponse(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}
	
	
	public LoginUserResponse(String token, String message, User user) {
		super();
		this.token = token;
		this.message = message;
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
