package com.owaiss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	public Optional<User> findByMobileNumber(String MobileNumber);
}
