package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loginlogoutregister.entity.Login;
import com.cg.loginlogoutregister.repository.ILoginRepository;
import com.cg.loginlogoutregister.service.ILoginService;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	ILoginService loginService;
	@Autowired
	ILoginRepository loginRepo;
	
	
	//validate login with valid userId and password

	@Test
	void testValidateLoginWithValidUserIdAndPassword() {
		Login user = new Login();
		user.setId(1);
		user.setUserId("admin");
		user.setPassword("admin@1234");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertEquals(user.getUserId(), dbUsr.getUserId());
		assertEquals(user.getPassword(), dbUsr.getPassword());	    
		}

	//validate login with invalid userId and password
	@Test
	void testValidateLoginWithInvalidUserIdAndPassword() {
		Login user = new Login();
		user.setId(1);
		user.setUserId("riya");
		user.setPassword("min@1234");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertNotEquals(user.getUserId(), dbUsr.getUserId());
		assertNotEquals(user.getPassword(), dbUsr.getPassword());
	}

      
	//validate login with valid userId and  invalid password
	@Test
	void testValidateLoginWithValidUserIdAndInvalidPassword() {
		Login user = new Login();
		user.setId(1);
		user.setUserId("admin");
		user.setPassword("riya@342");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertEquals(user.getUserId(), dbUsr.getUserId());
		assertNotEquals(user.getPassword(), dbUsr.getPassword());
	}
	//validate login with invalid userId and valid password
	@Test
	void testValidateLoginWithInvalidUserIdAndValidPassword() {
		Login user = new Login();
		user.setId(1);
		user.setUserId("mini");
		user.setPassword("admin@1234");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertNotEquals(user.getUserId(), dbUsr.getUserId());
		assertEquals(user.getPassword(), dbUsr.getPassword());
	}
	//validate login without userId and password
	@Test
	void testValidateLoginWithoutUserIdAndPassword() {
		Login user = new Login();
		user.setId(1);
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertNull(user.getUserId(), dbUsr.getUserId());
		assertNull(user.getPassword(), dbUsr.getPassword());
	}
	//validate login with valid userId and without password
	@Test
	void testValidateLoginWithValidUserIdAndWithoutPassword() {
		Login user = new Login();
		user.setId(1);
		user.setUserId("admin");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertEquals(user.getUserId(), dbUsr.getUserId());
		assertNull(user.getPassword(), dbUsr.getPassword());
	}
	
	//validate login without userId and with password
	@Test
	void testValidateLoginWithoutUserIdAndWithPassword() {
		Login user = new Login();
		user.setId(1);
		user.setPassword("admin@1234");
		Optional<Login> opt = loginRepo.findById(user.getId());
		Login dbUsr = opt.get();
		assertNull(user.getUserId(), dbUsr.getUserId());
		assertEquals(user.getPassword(), dbUsr.getPassword());
	}

}