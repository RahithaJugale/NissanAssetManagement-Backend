package com.nissan.common;

public class AccessDeniedException extends RuntimeException{	//user-defined exception

	public AccessDeniedException(String message) {
		super(message);
	}

}
