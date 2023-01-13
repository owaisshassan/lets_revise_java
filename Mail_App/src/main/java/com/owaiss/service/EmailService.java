package com.owaiss.service;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Emaill;

public interface EmailService {
	
	public String sendMail(Emaill email) throws EmailException,UserException;
	
	public String starMail(Integer emailID)throws EmailException,UserException;
	
	public String deleteMail(Integer emailID)throws EmailException,UserException;

}
