package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loginlogoutregister.entity.User;
import com.cg.loginlogoutregister.repository.IUserRepository;
import com.cg.loginlogoutregister.service.IUserService;

@SpringBootTest
public class RegisterApplicationTest {

	@Autowired
	IUserService regservice;
	@Autowired
	IUserRepository regRepo;

	static User getMockUser() {
		User user = new User();
		user.setUserid("userid");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("monishasekar353@gmail.com");
		user.setPassword("M0n1");
		user.setMobile_no("9840128654");
		return user;
	}

	@Test
	void findUserByUserId() throws Exception {
		User user = getMockUser();
		regservice.save(user);
		User temp = regservice.findUserByUserId("userid");
		assertEquals(user.toString(), temp.toString());

	}

	@Test
	void findAllUsers() throws Exception {
		List<User> userlist = regservice.getAllUsers();
		User user = getMockUser();
		regservice.save(user);
		List<User> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());

	}

	@Test
	void updateUser() throws Exception {
		User user = new User();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yaho.com");
		user.setPassword("M0n1");
		user.setMobile_no("9962440531");
		regservice.save(user);
		User temp = regservice.updateUser(user);
		assertEquals(user.toString(), temp.toString());
	}

	@Test
	void deleteUserByUserId() throws Exception {
		User user = regservice.deleteUserByUserId("mosekar");
		assertEquals("mosekar", user.getUserid());

	}

}
