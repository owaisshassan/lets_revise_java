package com.owaiss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owaiss.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByUserName(String userName);
	
}
