package com.owaiss.service;

import java.util.List;

import com.owaiss.exception.CourseException;
import com.owaiss.exception.StudentException;
import com.owaiss.model.Student;

public interface CourseService {

	public List<Student> getAllStudents(Integer courseID)throws CourseException,StudentException;
}
