package com.owaiss.service;

import java.util.List;

import com.owaiss.exception.CabException;
import com.owaiss.exception.DriverException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Cab;
import com.owaiss.model.Driver;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;

public interface UserService {

	public User add_user(User user) throws UserException;
	public String loginUser(LoginLogoutDTO dto) throws UserException,LoginException;
	public List<Driver> find_ride(User user,String key) throws UserException,DriverException,LoginException;
	public Cab book_ride(User user,String key,Integer driverId, Integer x, Integer y)throws UserException,DriverException,LoginException,CabException;

}
