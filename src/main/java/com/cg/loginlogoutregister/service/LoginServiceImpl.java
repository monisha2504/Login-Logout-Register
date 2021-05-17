package com.cg.loginlogoutregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;

	@Override
	public String login(Login user) throws Exception {
		Optional<Login> opt = loginRepo.findById(user.getId());
		if (!opt.isPresent()) {
			return "Id is not found";
		}
		Login dbUsr = opt.get();

		if (!dbUsr.getUserId().equals(user.getUserId()) || !dbUsr.getPassword().equals(user.getPassword())) {

			throw new UserNotFoundException("UserId or Password is invalid");
		}
		return "Succesfully logged in " + user.getUserId();

	}
}
