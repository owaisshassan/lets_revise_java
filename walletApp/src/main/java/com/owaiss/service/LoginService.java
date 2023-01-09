package com.owaiss.service;

import com.owaiss.exception.LoginException;
import com.owaiss.model.LoginDTO;

public interface LoginService {
	
	
	
	public String logIntoUserAccount(LoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;
	
	

}
