package com.cg.loginlogoutregister.service;

import com.cg.loginlogoutregister.entity.LoginEntity;
public interface ILoginService {
	
	String login(LoginEntity user);

	String logout(String userId);

}
