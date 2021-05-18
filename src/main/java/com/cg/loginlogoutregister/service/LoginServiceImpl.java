package com.cg.loginlogoutregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	


	@Override
	public String login(Login user) throws Exception {
		
		Login dbUsr = loginRepo.findById(user.getUserId()).get();

		if (!dbUsr.getUserId().equals(user.getUserId()) || !dbUsr.getPassword().equals(user.getPassword())) {

			throw new Exception("UserId or Password is invalid");
		}
		if(dbUsr.getUserId().equals(user.getUserId()) && dbUsr.getPassword().equals(user.getPassword())) {
          
	       user.setLoggedIn(true);
	       loginRepo.save(user);
         
		}
		return "Succesfully logged in " + user.getUserId() +" " +user.isLoggedIn() ;
		
	}


	@Override
	public String logout(String userId) throws Exception {
		Login dbUsr = loginRepo.findById(userId).get();
		if(dbUsr.getUserId().equals(userId) && dbUsr.isLoggedIn()==true )  {
	          
		       dbUsr.setLoggedIn(false);
		       loginRepo.save(dbUsr);
		       return "logout successfully";
			}
			throw new Exception("User not logged in");
	}
	
	
}
