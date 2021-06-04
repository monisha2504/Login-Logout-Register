package com.cg.loginlogoutregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.loginlogoutregister.entity.UserEntity;

@Service
public interface IUserService {
	public UserEntity findUserByUserId(String userid);

	public List<UserEntity> getAllUsers();
	/**
	 * creating a user in database
	 * @param user
	 * @return
	 */
	public UserEntity createUser(UserEntity user);

	public UserEntity updateUser(UserEntity user);

	public UserEntity deleteUserByUserId(String userid);

}
