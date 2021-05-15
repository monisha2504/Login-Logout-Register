package com.cg.loginlogoutregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.User;

@Service
public interface IUserService {
	public User findUserByUserId(String userid) throws Exception;

	public List<User> getAllUsers();

	public User save(User user) throws Exception;

	public User updateUser(User user) throws Exception;

	public User deleteUserByUserId(String userid);

}
