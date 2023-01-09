package com.owaiss.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userLoginId;
	
	@NotNull(message = "userName should not be null")
	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Please type alphabetic userName only")
	@Size(min=3,max=16, message = "userName should be of size min=3 and max=16")
	private String userName;
	
	@NotBlank
	@NotNull(message = "please fill the password field!")
	@Size(min = 6, max = 8, message = "Password must be 6-8 characters!")
	private String password;
	private String firstname;
	private String lastName;
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile number cannot be blank!")
	@Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	@Size(min = 10,message = "please enter valid mobile number!" )
	private String contact;
	@Email(message = "please enter valid email")
	private String email;
	
	@OneToOne
	private Wallet wallet;

	public User(
			@NotNull(message = "userName should not be null") @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Please type alphabetic userName only") @Size(min = 3, max = 16, message = "userName should be of size min=3 and max=16") String userName,
			@NotBlank @NotNull(message = "please fill the password field!") @Size(min = 6, max = 8, message = "Password must be 6-8 characters!") String password,
			String firstname, String lastName,
			@NotNull(message = "Mobile number cannot be null!") @NotBlank(message = "Mobile number cannot be blank!") @Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number") @Size(min = 10, message = "please enter valid mobile number!") String contact,
			@Email(message = "please enter valid email") String email, Wallet wallet) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstname = firstname;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.wallet = wallet;
	}

	public User(
			@NotNull(message = "userName should not be null") @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Please type alphabetic userName only") @Size(min = 3, max = 16, message = "userName should be of size min=3 and max=16") String userName,
			@NotBlank @NotNull(message = "please fill the password field!") @Size(min = 6, max = 8, message = "Password must be 6-8 characters!") String password,
			String firstname, String lastName,
			@NotNull(message = "Mobile number cannot be null!") @NotBlank(message = "Mobile number cannot be blank!") @Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number") @Size(min = 10, message = "please enter valid mobile number!") String contact,
			@Email(message = "please enter valid email") String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstname = firstname;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}
	
	
	
	
}
