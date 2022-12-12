package com.owaiss.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseID;
	private String courseName;
	
	@ManyToOne
	private List<Student> students=new ArrayList<>();
	
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Course(String courseName, List<Student> students) {
		super();
		this.courseName = courseName;
		this.students = students;
	}

	
	
	
}
