package com.owaiss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Emaill;
import com.owaiss.service.EmailService;

@RestController
@RequestMapping("/masaimail")
public class EmailController {
	
	@Autowired
	private EmailService emailServ;
	
	@PostMapping("/mail")
	public ResponseEntity<String> sendMailHandler(@RequestBody Emaill email) throws EmailException, UserException{
		String res= emailServ.sendMail(email);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PostMapping("/starred/{id}")
	public ResponseEntity<String> starMailHandler(@PathVariable("id") Integer id) throws EmailException, UserException{
		String res= emailServ.starMail(id);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMailHandler(@PathVariable("id") Integer id) throws EmailException, UserException{
		String res= emailServ.deleteMail(id);
		
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}

}
