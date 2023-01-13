package com.owaiss.service;

import java.util.List;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Emaill;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public String logIntoUserAccount(LoginLogoutDTO dto)throws LoginException;
	
	public List<Emaill> checkAllMails(String email) throws UserException, EmailException;
	
	public List<Emaill> checkAllStarredMails(String email) throws UserException, EmailException;
	
	public User updateUser(User user,String key) throws UserException;
	

}
