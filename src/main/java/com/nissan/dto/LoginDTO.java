package com.nissan.dto;

public class LoginDTO {

	//instance variables
	private String emailId;
	private String password;
	
	//default constructor
	public LoginDTO() {

	}
	//getters and setters
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [emailId=" + emailId + ", password=" + password + "]";
	}
	
}
