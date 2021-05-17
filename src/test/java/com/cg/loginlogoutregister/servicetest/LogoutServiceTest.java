package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.loginlogoutregister.entity.Logout;
import com.cg.loginlogoutregister.repository.ILogoutRepository;
import com.cg.loginlogoutregister.service.ILogoutService;

@SpringBootTest
public class LogoutServiceTest {

	@Autowired
	ILogoutService logoutservice;
	@Autowired
	ILogoutRepository logoutRepo;

     //validate with valid UserId
	@Test
	void testValidateWithUserId() {
		Logout user = new Logout();
		user.setId(1);
		Optional<Logout> opti = logoutRepo.findById(user.getId());
		Logout dbUsr = opti.get();
		assertEquals("admin", dbUsr.getUserId());    
		}

     //validate with invalid UserId
	@Test
	void testValidateWithInvalidUserId() {
		Logout user = new Logout();
		user.setId(1);
		Optional<Logout> opti = logoutRepo.findById(user.getId());
		Logout dbUsr = opti.get();
		assertNotEquals("riya", dbUsr.getUserId());    
		}
	//validate without UserId
	@Test
	void testValidateWithoutUserId() {
		Logout user = new Logout();
		user.setId(1);
		Optional<Logout> opti = logoutRepo.findById(user.getId());
		Logout dbUsr = opti.get();
		assertNull(user.getUserId(), dbUsr.getUserId());    
		}
	

}
