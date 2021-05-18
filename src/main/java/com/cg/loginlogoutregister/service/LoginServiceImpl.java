package com.cg.loginlogoutregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.LoginEntity;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	


	@Override
	public String login(LoginEntity user){
		
		Optional<LoginEntity> userfield = loginRepo.findById(user.getUserId());
		LoginEntity dbUsr=null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		
		if (dbUsr==null || !dbUsr.getUserId().equals(user.getUserId()) || !dbUsr.getPassword().equals(user.getPassword())) {

			throw new UserNotFoundException("UserId or Password is invalid");
		}
		if(dbUsr.getUserId().equals(user.getUserId()) && dbUsr.getPassword().equals(user.getPassword())) {
          
	       user.setLoggedIn(true);
	       loginRepo.save(user);
         
		}
		return "Succesfully logged in " + user.getUserId() +" " +user.isLoggedIn() ;
		
	}


	@Override
	public String logout(String userId)  {
		Optional<LoginEntity> userfield = loginRepo.findById(userId);
		LoginEntity dbUsr=null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if(dbUsr!=null && dbUsr.getUserId().equals(userId) && dbUsr.isLoggedIn())  {
	          
		       dbUsr.setLoggedIn(false);
		       loginRepo.save(dbUsr);
		       return "logout successfully";
			}
			throw new UserNotFoundException("User not logged in");
	}
	
	
}
