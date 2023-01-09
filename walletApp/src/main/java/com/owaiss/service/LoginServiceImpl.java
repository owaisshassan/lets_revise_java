package com.owaiss.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.LoginException;
import com.owaiss.model.CurrentUserSession;
import com.owaiss.model.LoginDTO;
import com.owaiss.model.User;
import com.owaiss.repository.CurrentUserSessionRepo;
import com.owaiss.repository.UserRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepo userDao;
	
	@Autowired
	private CurrentUserSessionRepo cusDao;
	
	
	@Override
	public String logIntoUserAccount(LoginDTO dto) throws LoginException {
		User existingUser= userDao.findByContact(dto.getMobileNo());
		
		if(existingUser == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  cusDao.findById(existingUser.getUserLoginId());
		
		if(validUserSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserLoginId(),key,LocalDateTime.now());
			
			cusDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
	}
	
	

	@Override
	public String logOutFromUserAccount(String key) throws LoginException {
		CurrentUserSession validUserSession = cusDao.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this key");
		}
		
		cusDao.delete(validUserSession);
		
		return "Logged Out !";
	}



	

	

	
	

}
