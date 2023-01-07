package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Login {
	
	//instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginId;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private Integer typeId;
	
	@ManyToOne
	@JoinColumn(name="typeId", insertable=false, updatable=false)
	private UserType userType;

	//default constructor
	public Login() {

	}

	//parameterized constructor
	public Login(Integer loginId, String username, String password, Integer typeId) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.typeId = typeId;
	}

	public Login(Integer loginId, String username, String password, Integer typeId, UserType userType) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.typeId = typeId;
		this.userType = userType;
	}

	//getters and setters
	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	//toString()
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", typeId=" + typeId
				+ ", userType=" + userType + "]";
	}
	
}
