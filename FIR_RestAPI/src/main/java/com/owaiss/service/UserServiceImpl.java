package com.owaiss.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.owaiss.exception.FIRException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;

import com.owaiss.model.CurrentUserSession;
import com.owaiss.model.FIR;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.repository.CurrentUserSessionRepo;

import com.owaiss.repository.FIRRepo;
import com.owaiss.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userDao;

	@Autowired
	private CurrentUserSessionRepo cusDao;
	
	@Autowired
	private FIRRepo firDao;
	
	
	
	//Add basic user details :
	@Override
	public User add_user(User user) throws UserException {
		Optional<User> uOpt= userDao.findByMobileNumber(user.getMobileNumber());
		
		if(uOpt.isPresent()) {
			throw new UserException("User already registered with this mobile number");
		}
		
		userDao.save(user);
		return user;
	}

	
	
	//Login with user details:
	@Override
	public String loginUser(LoginLogoutDTO dto) throws UserException, LoginException {
		Optional<User> uOpt= userDao.findByMobileNumber(dto.getContact());
		
		if(!uOpt.isPresent()) throw new UserException("User not registered with this mobile number");
		
		Optional<CurrentUserSession> cusOpt=  cusDao.findByContact(dto.getContact());
		
		if(cusOpt.isPresent()) throw new LoginException("User already logged in with this mobile Number");
		
		User u=uOpt.get();
		if(dto.getPassword().equals(u.getPassword())) {
			UUID uuid=UUID.randomUUID();
			String key=uuid.toString();
			
			CurrentUserSession cus=new CurrentUserSession(u.getMobileNumber(),key,LocalDateTime.now());
			return cus.toString();
		}else throw new LoginException("Please provide valid password");
	
	}


	//get list of all FIRs filed by the user:
	@Override
	public List<FIR> getAllFIRsFiledByUser(String key) throws UserException, FIRException, LoginException {
			
		CurrentUserSession cus= cusDao.findByUuid(key);
		if(cus == null) throw new LoginException("Please provide a valid key/Login first");
		Optional<User> u= userDao.findByMobileNumber(cus.getContact()); 
		
		User user= u.get();
		
		if(user.getFirs().size() == 0) throw new FIRException("No FIRs filed by this user");
		
		return user.getFirs();
	}


	
	//User can withdraw/delete an FIR within 24hrs of filing:
	@Override
	public String withdraw_FIR(String key, Integer firId) throws UserException, FIRException, LoginException {

		CurrentUserSession cus= cusDao.findByUuid(key);
		if(cus == null) throw new LoginException("Please provide a valid key/Login first");
		Optional<User> u= userDao.findByMobileNumber(cus.getContact()); 
		
		User user= u.get();
		
		if(user.getFirs().size() == 0) throw new FIRException("No FIRs filed by this user");
		
		List<FIR> firs=user.getFirs();
		
		boolean bool=false;
		
		for(int i=0;i<firs.size();i++) {
			FIR f=firs.get(i);
			if(f.getFirId() == firId && f.getTimeStamp().isBefore(LocalDateTime.now()) && f.getTimeStamp().compareTo(LocalDateTime.now())<=24) {
				firDao.delete(f);
				 bool=true;
				 break;
			}else if(f.getFirId() == firId && f.getTimeStamp().isBefore(LocalDateTime.now()) && f.getTimeStamp().compareTo(LocalDateTime.now())>24) {
			 	throw new FIRException("Sorry! only FIR filed within 24 hours of filing can be withdrawn");
			}
		}
		
		
		
		if(bool) return "FIR withdrawn successfully";
		else return "FIR could not be withdrawn";
	}

	
	

	
	

}





