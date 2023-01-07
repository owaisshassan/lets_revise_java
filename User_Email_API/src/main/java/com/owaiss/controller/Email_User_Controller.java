package com.owaiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Email;
import com.owaiss.model.User;
import com.owaiss.service.EmailService;
import com.owaiss.service.UserService;

@RestController
public class Email_User_Controller {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private EmailService emailServ;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsersHandler() throws UserException{
		return new ResponseEntity<List<User>>(userServ.retrieveAllUsers(),HttpStatus.OK);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUserHandler(@RequestBody User user) throws UserException{
		return new ResponseEntity<User>(userServ.createUser(user),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("id") Integer id) throws UserException{
		return new ResponseEntity<User>(userServ.retrieveUserById(id),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/users/id")
	public ResponseEntity<User> deleteUserHandler(@PathVariable("id") Integer id) throws UserException{
		return new ResponseEntity<User>(userServ.deleteUserById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/users/{id}/mail/{mail_id}")
	public ResponseEntity<Email> getEmailDetailforUserHandler(@PathVariable("id") Integer id,@PathVariable("mail_id") Integer mail_id) throws UserException, EmailException{
		return new ResponseEntity<Email>(emailServ.getEmailDetailforUser(id,mail_id),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/users/{id}/mail")
	public ResponseEntity<Email> createEmailForUserHandler(@PathVariable("id")Integer id,@RequestBody Email email) throws UserException, EmailException{
		return new ResponseEntity<Email>(emailServ.createEmailForUser(id, email),HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}
