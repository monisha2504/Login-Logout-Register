package com.cg.loginlogoutregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loginlogoutregister.entity.UserLogin;
@Repository
public interface IUserLoginRepository extends JpaRepository<UserLogin, Integer> {

	
	UserLogin findUserByUserid(String userid);
	
	
}
