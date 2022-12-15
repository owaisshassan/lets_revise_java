package com.owaiss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.DriverException;
import com.owaiss.model.Driver;
import com.owaiss.service.DriverService;

@RestController
@RequestMapping("/masaicab/driver")
public class DriverController {

	
	@Autowired
	private DriverService driverServ;
	
	
	@PostMapping("/register")
	public ResponseEntity<Driver> add_driverHandler(@Valid @RequestBody Driver driver) throws DriverException{
		Driver d= driverServ.add_driver(driver);
		
		return new ResponseEntity<Driver>(d,HttpStatus.CREATED);
	}
}
