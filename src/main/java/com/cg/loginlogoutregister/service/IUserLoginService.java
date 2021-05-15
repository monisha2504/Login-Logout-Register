package com.cg.loginlogoutregister.service;

import com.cg.loginlogoutregister.entity.UserLogin;

public interface IUserLoginService {

	UserLogin findById(int id);

	UserLogin login(UserLogin userLogin);
	UserLogin logout(String userid);

}
