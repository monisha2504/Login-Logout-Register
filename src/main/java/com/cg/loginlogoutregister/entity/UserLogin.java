package com.cg.loginlogoutregister.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserLogin {
	@Id
	private int id;
	private String userid;
	private String password;

	public UserLogin() {
		
	}

	public UserLogin(int id, String userid, String password) {
		this.id = id;
		this.userid = userid;
		this.password = password;
	}
    //getter and setter method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", userid=" + userid + ", password=" + password + "]";
	}

	

}
