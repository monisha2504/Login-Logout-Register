package com.cg.loginlogoutregister.dto;

import lombok.Data;

@Data
public class LoginDto {
	private String userId;
	private boolean isLoggedIn;
	private String userRole;

}
