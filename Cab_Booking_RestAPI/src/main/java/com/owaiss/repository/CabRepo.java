package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.Cab;

@Repository
public interface CabRepo extends JpaRepository<Cab, Integer>{

	
}
