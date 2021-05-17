package com.cg.loginlogoutregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.Logout;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.ILogoutRepository;

@Service
public class LogoutServiceImpl implements ILogoutService {
	@Autowired
	ILogoutRepository logoutRepo;

	@Override
	public String logout(Logout user) {
		Optional<Logout> opti = logoutRepo.findById(user.getId());
		if (!opti.isPresent()) {
			return null;
		}
		Logout dbUser = opti.get();

		if (!dbUser.getUserId().equals(user.getUserId())) {

			throw new UserNotFoundException("UserId doesn't exist");
		}

		return "Logged Out Successfully ";
	}

}
