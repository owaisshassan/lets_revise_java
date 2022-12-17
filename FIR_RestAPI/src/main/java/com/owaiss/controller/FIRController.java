package com.owaiss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.FIRException;
import com.owaiss.model.FIR;
import com.owaiss.service.FIRService;

@RestController
@RequestMapping("/masaifir/user")
public class FIRController {

	@Autowired
	private FIRService firServ;
	
	@PostMapping("/fir")
	public ResponseEntity<FIR> file_firHandler(@Valid @RequestBody FIR fir) throws FIRException{
		FIR filedFIR= firServ.file_fir(fir);
		
		return new ResponseEntity<FIR>(filedFIR,HttpStatus.CREATED);
	}
}
