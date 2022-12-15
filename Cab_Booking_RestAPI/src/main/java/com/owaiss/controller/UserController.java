package com.owaiss.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.CabException;
import com.owaiss.exception.DriverException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Cab;
import com.owaiss.model.Driver;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.service.UserService;

@RestController
@RequestMapping("/masaicab/user")
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
	
	
	@GetMapping("/findride")
	public ResponseEntity<List<Driver>> find_rideHandler(@Valid @RequestBody User user,@RequestParam String key) throws UserException, DriverException, LoginException{
		List<Driver> drivers= userServ.find_ride(user, key);
		
		return new ResponseEntity<List<Driver>>(drivers,HttpStatus.OK);
	}
	
	
	@PutMapping("/book/{driverId}/{x}/{y}")
	public ResponseEntity<Cab> book_rideHandler(@Valid @RequestBody User user,@RequestParam String key,@PathVariable("driverId") Integer driverId,@PathVariable("x") Integer x,@PathVariable("y") Integer y) throws UserException, DriverException, LoginException, CabException{
		Cab c= userServ.book_ride(user, key, driverId, x, y);
		
		return new ResponseEntity<Cab>(c,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
