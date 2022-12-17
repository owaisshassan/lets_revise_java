package com.owaiss.service;

import java.util.List;


import com.owaiss.exception.FIRException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;

import com.owaiss.model.FIR;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;

public interface UserService {

	public User add_user(User user) throws UserException;
	public String loginUser(LoginLogoutDTO dto) throws UserException,LoginException;
	public List<FIR> getAllFIRsFiledByUser(String key) throws UserException,FIRException,LoginException;
	public String withdraw_FIR(String key,Integer firId)throws UserException,FIRException,LoginException;

}
