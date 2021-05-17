/*package com.cg.loginlogoutregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginlogoutregister.entity.UserLogin;
import com.cg.loginlogoutregister.exception.UserLoginException;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.IUserLoginRepository;
import com.cg.loginlogoutregister.service.IUserLoginService;

@RestController
public class UserLoginController {

	@Autowired
	IUserLoginService usrService;
	@Autowired
	IUserLoginRepository usrRepo;
	
     
	@GetMapping("/user/{id}")
	public UserLogin findUserById(@PathVariable("id") int id) {
		 if(usrService.findById(id)==null) {
	    	   throw new UserNotFoundException("User not found with this id ");
	       }
		return usrService.findById(id);

	}
   //login service
	@PostMapping("/user")
	public UserLogin Login(@RequestBody UserLogin userLogin) throws Exception {
		if((userLogin.getUserid().isBlank()) || (userLogin.getPassword().isBlank())) {
			throw new Exception("Userid or Password in null");
		}
		UserLogin usr = usrRepo.findUserByUserid(userLogin.getUserid());
		
		if (usr.getUserid().equals(userLogin.getUserid()) && usr.getPassword().equals(userLogin.getPassword())) {

		   throw new UserLoginException("login successfully");
		}else {
			throw new UserNotFoundException("Userid or Password are invalid");
		}
	}
	
   //logout service
	@GetMapping("/logout/{userid}")
	public UserLogin Logout(@PathVariable("userid") String userid) {
		 if(usrRepo.findUserByUserid(userid)==null) {
	    	   throw new UserNotFoundException("Not logged in the device");
	       }else {
	    	   throw new UserLoginException("logged out successfully");
	       }
		

	}

	
	

}*/
