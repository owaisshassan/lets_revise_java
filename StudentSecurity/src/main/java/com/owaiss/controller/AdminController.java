package com.owaiss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.AdminException;

import com.owaiss.model.Admin;

import com.owaiss.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private AdminService adminServ;
	
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerStudentHandler(@RequestBody Admin admin) throws AdminException {
		Admin adm= adminServ.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(adm,HttpStatus.ACCEPTED);
	}

	

}
