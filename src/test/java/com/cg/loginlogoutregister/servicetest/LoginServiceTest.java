package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
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
	void testValidateLoginWithValidUserIdAndPassword() throws Exception {
		Login user = new Login();
		user.setUserId("admin");
		user.setPassword("admin@1234");
		loginService.login(user);
		Login dbUsr = loginRepo.findById(user.getUserId()).get();
		assertEquals(user.getUserId(), dbUsr.getUserId());
		assertEquals(user.getPassword(), dbUsr.getPassword());	    
		}

	//validate login with invalid userId and password
	@Test
	void testValidateLoginWithInvalidUserIdAndPassword() throws Throwable {
		Login user = new Login();
		user.setUserId("riya");
		user.setPassword("min@1234");
		assertThrows(Exception.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				loginService.login(user);
				
			}
		});
	}

      
	//validate login with valid userId and  invalid password
	@Test
	void testValidateLoginWithValidUserIdAndInvalidPassword() throws Exception {
		Login user = new Login();
		user.setUserId("admin");
		user.setPassword("riya@342");
        assertThrows(Exception.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				loginService.login(user);
				
			}
		});
		
	}
	//validate login with invalid userId and valid password
	@Test
	void testValidateLoginWithInvalidUserIdAndValidPassword() throws Exception {
		Login user = new Login();
		user.setUserId("mini");
		user.setPassword("admin@1234");
		assertThrows(Exception.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				loginService.login(user);
				
			}
		});	
	}
	
	//validate login with valid userId and without password
	@Test
	void testValidateLoginWithValidUserIdAndWithoutPassword() throws Exception {
		Login user = new Login();
		user.setUserId("admin");
		assertThrows(Exception.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				loginService.login(user);
				
			}
		});
	}
	
	

}