package com.owaiss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.ERole;
import com.owaiss.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(ERole name);

}
