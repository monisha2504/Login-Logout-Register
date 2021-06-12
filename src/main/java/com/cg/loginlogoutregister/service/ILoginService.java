package com.cg.loginlogoutregister.service;

import com.cg.loginlogoutregister.dto.LoginDto;
import com.cg.loginlogoutregister.entity.LoginEntity;
public interface ILoginService {
	/*
	 * Login User
	 */
	LoginDto login(LoginEntity user);
/*
 * Logout User
 */
	String logout(String userId);

}
