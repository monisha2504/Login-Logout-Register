package com.cg.loginlogoutregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.ILoginRepository;

@Service
public class LogoutServiceImpl implements ILogoutService {
	@Autowired
	ILoginRepository loginRepo;

	@Override
	public String logout(Login user) throws Exception {
			Optional<Login> opt = loginRepo.findById(user.getId());
			if (!opt.isPresent()) {
				return null;
			}
			Login dbUsr = opt.get();

			if (!dbUsr.getUserId().equals(user.getUserId())) {

				throw new UserNotFoundException("UserId not found");
			}
			if(dbUsr.getUserId().equals(user.getUserId()) && user.isLoggedIn()==true )  {
	          
		       user.setLoggedIn(false);
		       loginRepo.save(user);
		       return "logout successfully";
			}
			throw new Exception("User not logged in");
	}

}
