package com.owaiss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class WelcomeController {
	
	//This should not be protected
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("welcome to Spring App without security",HttpStatus.OK);
	}
	
	//This should be protected
	@GetMapping("/welcomeP")
	public ResponseEntity<String> welcomeP(){
		
			return new ResponseEntity<String>("Welcome to Spring App with Security",HttpStatus
     .ACCEPTED);
	}
	
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		
		return new ResponseEntity<String>("Welcome to Masai App for Admin",HttpStatus.
					 ACCEPTED);
	}
	

}
