package com.owaiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.CourseException;
import com.owaiss.exception.StudentException;
import com.owaiss.model.Student;
import com.owaiss.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseServ;
	
	@GetMapping("/course/{courseID}/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler(@PathVariable("courseID") Integer courseID) throws CourseException, StudentException{
		List<Student> students= courseServ.getAllStudents(courseID);
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}

}
