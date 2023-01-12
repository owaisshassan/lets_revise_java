package com.owaiss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.model.Employee;
import com.owaiss.repository.EmployeeDao;

@RestController
@RequestMapping("/app/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));
		
		Employee e=empDao.save(emp);
		
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	
	//only those employees can access this page who have the authority of admin
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		
		return new ResponseEntity<String>("welcome to Spring App for Admin",HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
