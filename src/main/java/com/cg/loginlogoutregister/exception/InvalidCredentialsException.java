package com.cg.loginlogoutregister.exception;

public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);

	}

	public InvalidCredentialsException(String message) {
		super(message);

	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);

	}
}
