package com.owaiss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.owaiss.model.FIR;
import com.owaiss.model.User;

@Repository
public interface FIRRepo extends JpaRepository<FIR, Integer>{
	
	public Optional<User> findUserByFirId(Integer firID);
}
