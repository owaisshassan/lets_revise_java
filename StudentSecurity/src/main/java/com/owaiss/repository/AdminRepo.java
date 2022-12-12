package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
