package com.owaiss.service;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Email;

public interface EmailService {

	public Email getEmailDetailforUser(Integer userId, Integer mailId)throws EmailException,UserException;
	public Email createEmailForUser(Integer userId,Email email)throws EmailException,UserException;
}
