package com.owaiss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	private String StudentName;
	
	@OneToOne
	private Course course;
	
	public Student(String studentName) {
		super();
		StudentName = studentName;
	}

	public Student(String studentName, Course course) {
		super();
		StudentName = studentName;
		this.course = course;
	}
	
	
	
}
