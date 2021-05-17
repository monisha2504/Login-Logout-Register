package com.cg.loginlogoutregister.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.loginlogoutregister.entity.User;
import com.cg.loginlogoutregister.repository.IUserRepository;
import com.cg.loginlogoutregister.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
public class RegisterApplicationMockitoTest {
	@InjectMocks
	UserServiceImpl regservice;
	@MockBean
	IUserRepository regRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test

	void findUserByUserId() throws Exception {
		User user = new User();
		user.setUserid("apple");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("monishasekar353@gmail.com");
		user.setPassword("M0n1");
		user.setMobile_no("9840128654");
		Mockito.when(regRepo.findById("apple")).thenReturn(Optional.of(user));
		User user1 = regservice.findUserByUserId("apple");
		assertEquals(user.toString(), user1.toString());

	}

	@Test

	void findAllUsers() throws Exception {
		User user = new User();
		user.setUserid("mango");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("monishasekar353@gmail.com");
		user.setPassword("M0n1");
		user.setMobile_no("9840128654");
		List<User> userlist = new ArrayList<>();
		userlist.add(user);
		Mockito.when(regRepo.findAll()).thenReturn(userlist);
		List<User> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());

	}

	@Test

	void updateUser() throws Exception {
		User user = new User();
		user.setUserid("useridd");
		user.setFirstname("newFirstname");
		user.setLastname("newLastname");
		user.setEmail("monishasekar25@gmail.com");
		user.setPassword("M0n1");
		user.setMobile_no("9962440531");
		Mockito.when(regRepo.findById("useridd")).thenReturn(Optional.of(user));
		Mockito.when(regRepo.save(user)).thenReturn(user);
		User temp = regservice.updateUser(user);
		assertEquals(user.toString(), temp.toString());
	}

	@Test

	void deleteUserByUserId() throws Exception {
		User user = new User();
		user.setUserid("useridd");
		user.setFirstname("newFirstname");
		user.setLastname("newLastname");
		user.setEmail("monishasekar25@gmail.com");
		user.setPassword("M0n1");
		user.setMobile_no("9962440531");
		Mockito.when(regRepo.findById("useridd")).thenReturn(Optional.of(user));
		User temp = regservice.deleteUserByUserId("useridd");
		assertEquals(user.toString(), temp.toString());

	}

}
