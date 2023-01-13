package com.owaiss.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginLogoutDTO {
	
	@NotNull(message = "Mobile number should not be null")
	private String contact;
	
	@NotNull(message = "password cannot be null")
	@Size(min = 6, max = 8, message = "Please provide pasword in range of 6 to 8 characters")
	private String password;

}
