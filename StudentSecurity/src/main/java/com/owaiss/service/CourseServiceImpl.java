package com.owaiss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.CourseException;
import com.owaiss.exception.StudentException;
import com.owaiss.model.Course;
import com.owaiss.model.Student;
import com.owaiss.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo courseDao;

	@Override
	public List<Student> getAllStudents(Integer courseID) throws CourseException, StudentException {
		Optional<Course> cOpt= courseDao.findById(courseID);
		
		if(cOpt.isPresent()) {
			Course c=cOpt.get();
			List<Student> students=c.getStudents();
			if(students.size()==0) {
				throw new StudentException("No students enrolled in this course");
			}else {
				return students;
			}
		}else {
			throw new CourseException("No course found with id : "+courseID);
		}
	}

}
