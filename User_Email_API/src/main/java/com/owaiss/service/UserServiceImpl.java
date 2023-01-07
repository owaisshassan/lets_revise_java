package com.owaiss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.UserException;
import com.owaiss.model.User;
import com.owaiss.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userDao;
	 
	@Override
	public List<User> retrieveAllUsers() throws UserException {
		List<User> users= userDao.findAll();
		if(users.size()>0) {
			return users;
		}else {
			throw new UserException("No users found!");
		}
	}

	@Override
	public User createUser(User user) throws UserException {
		if(user!=null) {
			userDao.save(user);
			return user;
		}else {
			throw new UserException("please provide valid user body");
		}
	}

	@Override
	public User retrieveUserById(Integer id) throws UserException {
		Optional<User> u= userDao.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			throw new UserException("No user present with id = "+id);
		}
	}

	@Override
	public User deleteUserById(Integer id) throws UserException {
		Optional<User> u= userDao.findById(id);
		if(u.isPresent()) {
			User user= u.get();
			userDao.delete(user);
			return user;
		}else {
			throw new UserException("No user present with id = "+id);
		}
	}

}
