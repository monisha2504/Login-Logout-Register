package com.cg.loginlogoutregister.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginResponseError {

	private int status;
	private String message;
	private long timestamp;

}
