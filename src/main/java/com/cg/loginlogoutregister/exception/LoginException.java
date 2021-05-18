package com.cg.loginlogoutregister.exception;

public class LoginException extends RuntimeException {

	public LoginException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LoginException(String message) {
		super(message);
		
	}

	public LoginException(Throwable cause) {
		super(cause);
		
	}

	
}
