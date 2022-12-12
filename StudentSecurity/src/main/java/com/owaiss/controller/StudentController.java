package com.owaiss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.StudentException;
import com.owaiss.model.Student;
import com.owaiss.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student stu) throws StudentException{
		Student student= studentServ.registerStudent(stu);
		
		return new ResponseEntity<Student>(student,HttpStatus.ACCEPTED);
	}

}
