package com.owaiss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Email;
import com.owaiss.model.User;
import com.owaiss.repository.EmailRepo;
import com.owaiss.repository.UserRepo;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private EmailRepo emailDao;
	
	@Autowired
	private UserRepo userDao;
	
	@Override
	public Email getEmailDetailforUser(Integer userId, Integer mailId) throws EmailException, UserException {
		Optional<User> u= userDao.findById(userId);
		if(u.isPresent()) {
			User user=u.get();
			Email userEmail=user.getEmail();
			if(userEmail!=null) {
				return userEmail;
			}else {
				throw new EmailException("No email found for user with id : "+userId);
			}
			
		}else {
			throw new UserException("No User found with id : "+userId);
		}
	}

	@Override
	public Email createEmailForUser(Integer userId, Email email) throws EmailException, UserException {
		Optional<User> u= userDao.findById(userId);
		if(u.isPresent()) {
			User user=u.get();
			Email userEmail=user.getEmail();
			if(userEmail==null) {
				user.setEmail(email);
				return email;
			}else {
				throw new EmailException("Email already created for user with id : "+userId);
			}
			
		}else {
			throw new UserException("No User found with id : "+userId);
		}
	}

}
