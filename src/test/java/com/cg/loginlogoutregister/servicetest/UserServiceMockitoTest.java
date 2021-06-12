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

import com.cg.loginlogoutregister.entity.UserEntity;
import com.cg.loginlogoutregister.exception.UserNotFoundException;
import com.cg.loginlogoutregister.repository.IUserRepository;
import com.cg.loginlogoutregister.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
public class UserServiceMockitoTest {
	@InjectMocks
	UserServiceImpl regservice;
	@MockBean
	IUserRepository regRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test

	void findUserByUserId() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserId("apple");
		user.setFirstName("firstname");
		user.setLastName("Lastname");
		user.setEmail("monishasekar353@gmail.com");
		user.setPassword("M0n1");
		user.setMobileNumber("9840128654");
		Mockito.when(regRepo.findById("apple")).thenReturn(Optional.of(user));
		UserEntity user1 = regservice.findUserByUserId("apple");
		assertEquals(user.toString(), user1.toString());

	}

	@Test

	void findAllUsers() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserId("mango");
		user.setFirstName("firstname");
		user.setLastName("Lastname");
		user.setEmail("monishasekar353@gmail.com");
		user.setPassword("M0n1");
		user.setMobileNumber("9840128654");
		List<UserEntity> userlist = new ArrayList<>();
		userlist.add(user);
		Mockito.when(regRepo.findAll()).thenReturn(userlist);
		List<UserEntity> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());

	}

	@Test

	void updateUser() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserId("useridd");
		user.setFirstName("newFirstname");
		user.setLastName("newLastname");
		user.setEmail("monishasekar25@gmail.com");
		user.setPassword("M0n1");
		user.setMobileNumber("9962440531");
		Mockito.when(regRepo.findById("useridd")).thenReturn(Optional.of(user));
		Mockito.when(regRepo.save(user)).thenReturn(user);
		UserEntity temp = regservice.updateUser(user);
		assertEquals(user.toString(), temp.toString());
	}

	@Test

	void deleteUserByUserId() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserId("useridd");
		user.setFirstName("newFirstname");
		user.setLastName("newLastname");
		user.setEmail("monishasekar25@gmail.com");
		user.setPassword("M0n1");
		user.setMobileNumber("9962440531");
		Mockito.when(regRepo.findById("useridd")).thenReturn(Optional.of(user));
		UserEntity temp = regservice.deleteUserByUserId("useridd");
		assertEquals(user.toString(), temp.toString());

	}

}
