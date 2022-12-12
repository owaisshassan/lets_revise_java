package com.owaiss.service;

import com.owaiss.exception.StudentException;
import com.owaiss.model.Student;

public interface StudentService {

	public Student registerStudent(Student s) throws StudentException;
	
	
}
