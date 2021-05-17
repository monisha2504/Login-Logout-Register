package com.cg.loginlogoutregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loginlogoutregister.entity.Logout;

@Repository
public interface ILogoutRepository extends JpaRepository<Logout, Integer> {

}
