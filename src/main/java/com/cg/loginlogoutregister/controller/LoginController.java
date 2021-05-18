package com.cg.loginlogoutregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginlogoutregister.entity.LoginEntity;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.service.ILoginService;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginService;
	// login service
	@PostMapping("/login")
	public String Login(@RequestBody LoginEntity user) {
		if (loginService.login(user)==null) {
			throw new UserNotFoundException("Userid or Password in null");
		}
		return loginService.login(user);
	}
    //logout service
	@GetMapping("/logout/{userId}")
	public String Logout( @PathVariable("userId")String userId){
		return loginService.logout(userId);
	}

}
