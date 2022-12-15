package com.owaiss.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.model.Role;
import com.owaiss.payload.request.LoginRequest;
import com.owaiss.payload.request.SignupRequest;
import com.owaiss.payload.response.UserResponse;
import com.owaiss.repository.RoleRepo;
import com.owaiss.repository.UserRepo;
import com.owaiss.security.jwt.JwtUtils;
import com.owaiss.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginReq){
		//logic to load user from database by mapping provided username and password
		 //get the Authentication object
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
		
		List<String> roles = userDetails.getAuthorities().stream().map(obj -> obj.getAuthority()).collect(Collectors.toList());
		
		UserResponse userResponse =new UserResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
		
		return  ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(userResponse);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupReq){
		//logic for saving user details in database
		return new ResponseEntity<UserResponse>(HttpStatus.ACCEPTED);
	}
	
}
