package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.service.ILogoutService;
import com.cg.loginlogoutregister.repository.ILoginRepository;


@SpringBootTest
public class LogoutServiceTest {

	@Autowired
	ILogoutService logoutservice;
	@Autowired
	ILoginRepository loginRepo;
	
	//validate when user is logged in 

		@Test
		void testValidateWhenUserIsLoggedIn() {
			Login user = new Login();
			user.setId(1);
			user.setUserId("admin");
			user.setLoggedIn(true);
			Optional<Login> opt = loginRepo.findById(user.getId());
			Login dbUsr = opt.get();
			assertEquals(user.getUserId(), dbUsr.getUserId());
			assertEquals(user.isLoggedIn(), true);	    
			}
		
		//validate when user is not logged in

		@Test
		void testValidateWhenUserIsNotLoggedIn() {
			Login user = new Login();
			user.setId(1);
			user.setUserId("admin");
			Optional<Login> opt = loginRepo.findById(user.getId());
			Login dbUsr = opt.get();
			assertEquals(user.getUserId(), dbUsr.getUserId());
			assertEquals(user.isLoggedIn(), false);	    
			}


}
