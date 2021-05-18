package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loginlogoutregister.entity.UserEntity;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.IUserRepository;
import com.cg.loginlogoutregister.service.IUserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	IUserService regservice;
	@Autowired
	IUserRepository regRepo;

	static UserEntity getMockUser() {
		UserEntity user = new UserEntity();
		user.setUserid("userid");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("abc353@gmail.com");
		user.setPassword("M0n1sha04");
		user.setMobileNumber("9840128654");
		return user;
	}

//Test READ
	@Test
	void findUserByUserId() throws UserNotFoundException {
		UserEntity user = getMockUser();
		regservice.createUser(user);
		UserEntity temp = regservice.findUserByUserId("userid");
		assertEquals(user.toString(), temp.toString());

	}

//Test READ
	@Test
	void findAllUsers() throws UserNotFoundException {
		List<UserEntity> userlist = regservice.getAllUsers();
		UserEntity user = getMockUser();
		regservice.createUser(user);
		List<UserEntity> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());
	}

//Test UPDATE
	@Test
	void updateUser() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yaho0.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		regservice.createUser(user);
		UserEntity temp = regservice.updateUser(user);
		assertEquals(user.toString(), temp.toString());
	}

//Test DELETE
	@Test
	void deleteUserByUserId() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yahoo.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		regservice.createUser(user);
		UserEntity temp = regservice.deleteUserByUserId("Monisha");
		assertEquals(user.toString(), temp.toString());
	}

}
