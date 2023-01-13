package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	
	 public  CurrentUserSession  findByUuid(String uuid);
	 
	 public CurrentUserSession findByEmail(String email);
}
