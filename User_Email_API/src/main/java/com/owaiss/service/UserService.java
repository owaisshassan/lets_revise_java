package com.owaiss.service;

import java.util.List;

import com.owaiss.exception.UserException;
import com.owaiss.model.User;

public interface UserService {
		
	public List<User> retrieveAllUsers() throws UserException;
	public User createUser(User user) throws UserException;
	public User retrieveUserById(Integer id) throws UserException;
	public User deleteUserById(Integer id) throws UserException;
	
	
	
}
