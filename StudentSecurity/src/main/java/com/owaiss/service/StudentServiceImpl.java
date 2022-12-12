package com.owaiss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.StudentException;
import com.owaiss.model.Student;
import com.owaiss.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo stuDao;
	
	@Override
	public Student registerStudent(Student s) throws StudentException{
		Optional<Student> stu= stuDao.findById(s.getRoll());
		
		if(stu.isPresent()) {
			throw new StudentException("Student already exists!");
		}else {
			Student student=stu.get();
			stuDao.save(student);
			return student;
		}
	}

}
