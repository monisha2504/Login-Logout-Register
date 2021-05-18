package com.cg.loginlogoutregister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "login")
public class Login {

	@GeneratedValue
	private int id;
	@Id
	private String userId;
	private String password;
    private boolean isLoggedIn = false;
}
