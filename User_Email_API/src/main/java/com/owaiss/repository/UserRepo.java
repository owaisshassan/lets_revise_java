package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
