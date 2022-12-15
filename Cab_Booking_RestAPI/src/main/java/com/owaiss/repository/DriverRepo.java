package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>{
	
}
