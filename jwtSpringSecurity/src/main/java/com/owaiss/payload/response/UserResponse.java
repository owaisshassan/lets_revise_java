package com.owaiss.payload.response;

import java.util.List;


import com.owaiss.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private Long id;
	
	private String username;
	
	private String emai;
	
	private List<String> roles;
}
