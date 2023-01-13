package com.owaiss.model;




import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	
	@Id
	@Email(message = "please provide a valid email address")
	private String email;
	
	@NotNull(message = "First Name should not be null")
	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Please type alphabetic First Name only")
	@Size(min=3,max=16, message = "firstName should be of size min=3 and max=16")
	private String firstName;
	
	@NotNull(message = "Last Name should not be null")
	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Please type alphabetic Last Name only")
	@Size(min=3,max=16, message = "lastName should be of size min=3 and max=16")
	private String lastName;
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile field cannot be blank!")
	@Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Please enter valid 10 digit mobile number")
	@Size(min = 10, max = 10, message = "Please enter valid 10 digit mobile number!")
	private String mobileNumber;
	
	@NotBlank(message = "password field cannot be blank!")
	@NotNull(message = "please fill the password field!")
	@Size(min = 6, max = 12, message = "Password must be 6-12 characters!")
	@Pattern(regexp =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,12}$")
	private String password;
	
	@NotNull(message = "please provide your DOB")
	@Past(message = "DOB cannot be in future date!")
	private LocalDate dateOfBirth;
	
	
	
	@OneToMany
	private List<Emaill> allMails;
	
	@OneToMany
	private List<Emaill> starredMails;
	
	
	
	
	
	
	
	
	
	
	
	
}
