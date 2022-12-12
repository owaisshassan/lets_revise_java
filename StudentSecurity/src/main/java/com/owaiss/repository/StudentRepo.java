package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
