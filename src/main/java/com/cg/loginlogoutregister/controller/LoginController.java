package com.cg.loginlogoutregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.service.ILoginService;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginService;
	
	// login service
	@PostMapping("/login")
	public String Login(@RequestBody Login user) throws Exception {
		if ((user.getUserId().isBlank()) || (user.getPassword().isBlank())) {
			throw new Exception("Userid or Password in null");
		}
		return loginService.login(user);
	}

}
