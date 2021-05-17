package com.cg.loginlogoutregister.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RegisterUser")
public class User {
	@Id
	@NotEmpty
	@Pattern(regexp = "[A-Za-z]+")
	@Size(min = 4, message = "Userid is should have atleast 4 character ")
	private String userid;
	@Pattern(regexp = "[A-Za-z0-9]+")
	@Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters")
	private String password;
	@Pattern(regexp = "[A-Za-z]+")
	@Size(min = 7, max = 10, message = "Firstname should have atleast 7 characters not less than 10 characters")
	private String firstname;
	@Pattern(regexp = "[A-Za-z]+")
	@Size(min = 7, max = 10, message = "Lastnmae should have atleast 7 characters not less than 10 characters")
	private String lastname;
	@Pattern(regexp = "^[0-9]{10}$")
	@Size(min = 10, max = 10, message = "Mobile_no less than 10 is Invalid")
	private String mobile_no;
	@Email
	@NotEmpty
	private String email;

}
