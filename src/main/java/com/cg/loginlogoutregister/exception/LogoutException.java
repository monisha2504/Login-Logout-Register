package com.cg.loginlogoutregister.exception;

public class LogoutException extends RuntimeException {

	public LogoutException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LogoutException(String message) {
		super(message);
		
	}

	public LogoutException(Throwable cause) {
		super(cause);
		
	}

}
