package com.owaiss.service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.CurrentUserSession;
import com.owaiss.model.Emaill;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.repository.CurrentUserSessionRepo;
import com.owaiss.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userDao;
	
	@Autowired
	private CurrentUserSessionRepo cusDao;

	@Override
	public User registerUser(User user) throws UserException {
		User u = userDao.findByEmail(user.getEmail());
		
		if(u!=null) {
			throw new UserException("User already Exists!");
		}else {
			return userDao.save(user);
		}
	}

	@Override
	public String logIntoUserAccount(LoginLogoutDTO dto) throws LoginException {
		User existingUser= userDao.findByMobileNo(dto.getContact());
		
		if(existingUser !=null) {
			CurrentUserSession loggedInUser= cusDao.findByEmail(existingUser.getEmail());
			
			if(loggedInUser!=null) {
				throw new LoginException("User already loggedIn with this email address!");
			}
			
			if(existingUser.getPassword().equals(dto.getPassword())) {
				
				RandomGenerator randomGen = RandomGenerator.of("UUID");
				String key= randomGen.toString();
				
				CurrentUserSession currUserSession=new CurrentUserSession(existingUser.getEmail(),key,LocalDateTime.now());
				cusDao.save(currUserSession);
				
				return currUserSession.toString();
			}else {
				throw new LoginException("please enter a valid password!");
			}
		}
		return "User Logged In Successfully!";
	}

	@Override
	public List<Emaill> checkAllMails(String email) throws UserException, EmailException {
		CurrentUserSession cus= cusDao.findByEmail(email);
		if(cus!=null) {
			User u= userDao.findByEmail(email);
			List<Emaill> mails=u.getAllMails();
			if(mails.size()==0) {
				throw new EmailException("No mails found!");
			}else return mails;
		}else {
			throw new UserException("please login first!");
		}
	}

	@Override
	public List<Emaill> checkAllStarredMails(String email) throws UserException, EmailException {
		CurrentUserSession cus= cusDao.findByEmail(email);
		if(cus!=null) {
			User u= userDao.findByEmail(email);
			List<Emaill> starMails=u.getStarredMails();
			if(starMails.size()==0) {
				throw new EmailException("No mails found!");
			}else return starMails;
		}else {
			throw new UserException("please login first!");
		}
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("No User not loggedIn with given Key");
		}else {
			if(loggedInUser.getEmail() != user.getEmail()) {
				throw new UserException("Please provide correct userId");
			}
			
			User u= userDao.findByEmail(user.getEmail());
			
			if(u!=null) {
				userDao.save(user);
			}else {
				throw new UserException("user not registered with email -> "+user.getEmail());
			}
			
		}
		
		return user;
	}

}
