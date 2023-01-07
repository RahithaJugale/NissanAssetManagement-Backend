package com.nissan.common;

import org.springframework.http.HttpStatus;

public class APIResponse {				//to store response from application server

	private Object data;			//emailId, roleId, jwtToken
	private Object error;			//error message
	
	//default constructor
	public APIResponse() {

		this.data = data;
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
}
