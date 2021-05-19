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
	public String Login(@RequestBody LoginEntity loginentity) {
		String message=null;
		if (loginentity.getUserid()==null || loginentity.getPassword()==null || loginentity.getUserid().equals("")||loginentity.getPassword().equals("")) {
			throw new UserNotFoundException("Userid or Password is invalid");
		}	
		UserEntity userfield = userService.findUserByUserId(loginentity.getUserid());
		if(userfield !=null && userfield.getPassword().equals(loginentity.getPassword())) {
			message = loginService.login(loginentity);
		}
		else if(userfield!=null){
			throw new UserNotFoundException("Userid or Password is5 invalid");
		}
		else  {
			throw new UserNotFoundException("User Not Registered");
		}
		return message;
	}
    //logout service
	@GetMapping("/logout/{userId}")
	public String Logout( @PathVariable("userId")String userId){
		return loginService.logout(userId);
	}

}
