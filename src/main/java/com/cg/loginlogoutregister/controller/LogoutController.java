package com.cg.loginlogoutregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginlogoutregister.entity.Logout;
import com.cg.loginlogoutregister.service.ILogoutService;

@RestController
public class LogoutController {

	@Autowired
	ILogoutService logoutService;

	@PostMapping("/logout")
	public String Logout(@RequestBody Logout user) throws Exception {
		if ((user.getUserId().isBlank())) {
			throw new Exception("UserId is blank");
		}
		return logoutService.logout(user);
	}

}
