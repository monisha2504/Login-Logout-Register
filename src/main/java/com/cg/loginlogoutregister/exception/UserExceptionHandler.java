package com.cg.loginlogoutregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.loginlogoutregister.entity.SuccessFactor;
import com.cg.loginlogoutregister.entity.UserErrorMessage;

@ControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<UserErrorMessage> handleExeption(UserNotFoundException exception) {
		UserErrorMessage error = new UserErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<UserErrorMessage> handleException(Exception exception) {
		UserErrorMessage error = new UserErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<SuccessFactor> handleException(UserLoginException exception1 ) {
		SuccessFactor success = new SuccessFactor();
		success.setStatus(HttpStatus.OK.value()); 
		success.setMessage(exception1.getMessage());
		success.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
