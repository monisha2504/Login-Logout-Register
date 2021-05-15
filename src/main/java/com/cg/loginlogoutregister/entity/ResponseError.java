package com.cg.loginlogoutregister.entity;

public class ResponseError {

	private int status;
	private String message;
	private long timestamp;
    
	public ResponseError() {
		
	}
	
	public ResponseError(int status, String message, long timestamp) {
		this.status = status;
		this.message = message;
		this.setTimestamp(timestamp);
	}
  

	//getter and setter method
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ResponseError [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

	
}
