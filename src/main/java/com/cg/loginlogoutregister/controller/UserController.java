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


import com.cg.loginlogoutregister.entity.UserEntity;

import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService regservice;
//READ
	
	@GetMapping("/user/userid/{userid}")
	public UserEntity findUserByUserId(@PathVariable String userid){
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		return regservice.findUserByUserId(userid);
	}

	@GetMapping("/user/findallusers")
	public List<UserEntity> findAllusers() {
		return regservice.getAllUsers();

	}
//WRITE
	
	@PostMapping("/user/save")
	public UserEntity save(@Valid @RequestBody UserEntity user){
		return regservice.createUser(user);
	}


//UPDATE
	
	@PutMapping("/user/{userid}/update")
	public UserEntity updateUser(@PathVariable String userid,@Valid @RequestBody UserEntity user){
		return regservice.updateUser(user);
		
	}
//DELETE
	
	@DeleteMapping("/user/{userid}")
	public UserEntity deleteUserByUserId(@PathVariable String userid){
		if(regservice.findUserByUserId(userid)==null){
		throw new UserNotFoundException("User not found with Userid");	
		}
		return regservice.deleteUserByUserId(userid);
	}
}
