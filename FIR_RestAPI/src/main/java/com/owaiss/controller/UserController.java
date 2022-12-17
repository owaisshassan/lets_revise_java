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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.FIRException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.FIR;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.service.UserService;



@RestController
@RequestMapping("/masaifir/user")
public class UserController {

	

	@Autowired
	private UserService userServ;
	
	@PostMapping("/register")
	public ResponseEntity<User> add_userHandler(@Valid @RequestBody User user) throws UserException{
		User u= userServ.add_user(user);
		
		return  new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler(@Valid @RequestBody LoginLogoutDTO dto) throws UserException, LoginException{
		String msg= userServ.loginUser(dto);
		
		return  new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("/fir")
	public ResponseEntity<List<FIR>> getAllFIRsFiledByUserHandler(@Valid @RequestParam String key) throws UserException, LoginException, FIRException{
		List<FIR> firs= userServ.getAllFIRsFiledByUser(key);
		
		return new ResponseEntity<List<FIR>>(firs,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/fir/{firId}")
	public ResponseEntity<String> withdraw_FIRHandler(@Valid @RequestParam String key, @PathVariable("firId") Integer firId) throws UserException, FIRException, LoginException{
		String deletedFIR= userServ.withdraw_FIR(key, firId);
		
		return new ResponseEntity<String>(deletedFIR,HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
