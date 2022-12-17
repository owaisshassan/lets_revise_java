package com.owaiss.model;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginLogoutDTO {
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile field cannot be blank!")
	@Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Please enter valid 10 digit mobile number")
	@Size(min = 10, max = 10, message = "Please enter valid 10 digit mobile number!")
	private String contact;
	
	@NotNull(message = "password cannot be null")
	@Size(min = 6, max = 8, message = "Please provide pasword in range of 6 to 8 characters")
	private String password;

}
