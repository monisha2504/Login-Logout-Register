package com.cg.loginlogoutregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginlogoutregister.entity.User;

import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService regservice;

	@GetMapping("/user/userid/{userid}")
	public User findUserByUserId(@PathVariable String userid) throws Exception {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		return regservice.findUserByUserId(userid);
	}

	@GetMapping("/user/findallusers")
	public List<User> findAllusers() {
		return regservice.getAllUsers();

	}

	@PostMapping("/user/save")
	public User save(@Valid @RequestBody User register) throws Exception {
		return regservice.save(register);
	}

	@PutMapping("/user/{userid}/update")
	public User updateUser(@PathVariable String userid,@Valid @RequestBody User register) throws Exception {
		return regservice.updateUser(register);
	}

	@DeleteMapping("/user/{userid}")
	public User deleteUserByUserId(@PathVariable String userid) throws Exception  {
		if(regservice.findUserByUserId(userid)==null){
		throw new Exception("User not found with Userid");	
		}
		return regservice.deleteUserByUserId(userid);
	}
}
