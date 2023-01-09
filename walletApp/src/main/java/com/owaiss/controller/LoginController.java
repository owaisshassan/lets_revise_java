package com.owaiss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.LoginException;
import com.owaiss.model.LoginDTO;
import com.owaiss.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService LoginService;
	
	
	//User login:
	
//  http://localhost:8888/user/login	
	@PostMapping("/user/login")
	public ResponseEntity<String> logInUserHandler(@Valid @RequestBody LoginDTO dto) throws LoginException {
		
		String result = LoginService.logIntoUserAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	
//  http://localhost:8888/user/logout	
	@PostMapping("/user/logout")
	public String logoutUserHandler(@Valid @RequestParam(required = false) String key) throws LoginException {
		
		return LoginService.logOutFromUserAccount(key);
	}

	


}
