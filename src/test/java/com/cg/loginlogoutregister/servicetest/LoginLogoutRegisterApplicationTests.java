package com.cg.loginlogoutregister.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loginlogoutregister.entity.UserLogin;
import com.cg.loginlogoutregister.repository.IUserLoginRepository;
import com.cg.loginlogoutregister.service.IUserLoginService;

@SpringBootTest
class LoginLogoutRegisterApplicationTests {

	@Autowired
	IUserLoginService usrservice;
	@Autowired
	IUserLoginRepository usrRepo;
	
	
	@Test
	@Disabled
	public void testFindUserByName() {
		String userid = "admin";
		UserLogin usr = usrRepo.findUserByUserid(userid);
		assertThat(usr).isNotNull();
	}

}
