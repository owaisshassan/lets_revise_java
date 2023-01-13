package com.owaiss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Emaill;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.service.UserService;



@RestController
@RequestMapping("/masaimail")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) throws UserException{
		User u=userServ.registerUser(user);
		
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	

	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler(@Valid @RequestBody LoginLogoutDTO dto) throws UserException, LoginException{
		String res=userServ.logIntoUserAccount(dto);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@GetMapping("/mail")
	public ResponseEntity<List<Emaill>> checkAllMailsHandler(@RequestParam String email) throws UserException, EmailException {
		List<Emaill> allMails=userServ.checkAllMails(email);
		
		return new ResponseEntity<List<Emaill>>(allMails,HttpStatus.OK);
	}
	
	@GetMapping("/starred")
	public ResponseEntity<List<Emaill>> checkAllStarredMailsHandler(@RequestParam String email) throws UserException, EmailException {
		List<Emaill> starMails=userServ.checkAllStarredMails(email);
		
		return new ResponseEntity<List<Emaill>>(starMails,HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user,@RequestParam(required = false) String key) throws UserException{
		User u=userServ.updateUser(user, key);
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	
	
	
	
	

}
