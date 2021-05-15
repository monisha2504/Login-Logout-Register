package com.cg.loginlogoutregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.UserLogin;
import com.cg.loginlogoutregister.repository.IUserLoginRepository;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

	@Autowired
	IUserLoginRepository usrRepo;
	

	@Override
	public UserLogin findById(int id) {

		Optional<UserLogin> opt = usrRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public UserLogin login(UserLogin userLogin) {
		
		return usrRepo.findUserByUserid(userLogin.getUserid());
	}
    
	@Override
	public UserLogin logout(String userid) {
		
		 return usrRepo.findUserByUserid(userid);
	
	}

}
