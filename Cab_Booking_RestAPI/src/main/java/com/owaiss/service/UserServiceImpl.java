package com.owaiss.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.CabException;
import com.owaiss.exception.DriverException;
import com.owaiss.exception.LoginException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Cab;
import com.owaiss.model.CurrentUserSession;
import com.owaiss.model.Driver;
import com.owaiss.model.LoginLogoutDTO;
import com.owaiss.model.User;
import com.owaiss.repository.CurrentUserSessionRepo;
import com.owaiss.repository.DriverRepo;
import com.owaiss.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userDao;

	@Autowired
	private CurrentUserSessionRepo cusDao;
	
	@Autowired
	private DriverRepo driverDao;
	
	
	
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

	
	//This Method will return a list of available rides within 5 unit of distance:
	@Override
	public List<Driver> find_ride(User user, String key)
			throws UserException, DriverException, LoginException {
		List<Driver> drivers=new ArrayList<>();
		
		Optional<User> uOpt=userDao.findByMobileNumber(user.getMobileNumber());
		
		if(uOpt.isPresent()) {
			CurrentUserSession cus= cusDao.findByUuid(key);
			if(cus != null) {
				List<Driver> allDrivers= driverDao.findAll();
				allDrivers.forEach(d -> {
					Integer[] user_coordinates=user.getCurrentPosition();
					Integer user_x= user_coordinates[0];
					Integer user_y= user_coordinates[1];
					
					Integer[] driver_coordinates=d.getDriverCurrentPosition();
					Integer driver_x= driver_coordinates[0];
					Integer driver_y= driver_coordinates[1];
					
					
					Double x=Math.pow((driver_x-user_x), 2);
					Double y=Math.pow((driver_y-user_y), 2);
					
					Double distance=Math.sqrt(x+y);
					
					if(distance <=5) drivers.add(d);
				});
			}else throw new LoginException("Please provide a valid key");
		}else throw new UserException("User with this Mobile Number not registered");
		
		
		if(drivers.size()==0) throw new DriverException("No drivers/cabs available within 5Kms range");
		
		return drivers;
	}
	
	
	
	int bool=0;

	
	//This method will book the ride and update
	//the position of the driver and the user to the destination given
	@Override
	public Cab book_ride(User user,String key,Integer driverId, Integer x, Integer y)
			throws UserException, DriverException, LoginException,CabException {
		
		Cab cab=null;
		
		
		List<Driver> availableDrivers= find_ride(user, key);
		
		availableDrivers.forEach(d -> {
			if(d.getDriverId() == driverId) {
				Integer[] driverCurrLocation= d.getDriverCurrentPosition();
				driverCurrLocation[0] = x;
				driverCurrLocation[1]=y;
				
				Integer[] userCurrLocation=user.getCurrentPosition();
				userCurrLocation[0]=x;
				userCurrLocation[1]=y;
				
				cab.setDriver(d);
				cab.setCabNumber(d.getCab().getCabNumber());
				cab.setCabType(d.getCab().getCabType());
				
				user.setDriver(d);
				d.setCab(cab);
				userDao.save(user);
				driverDao.save(d);
			}
		});
		
		if(cab == null) throw new CabException("No Cab available");
		
		return cab;
	}
	
	
	

}





//availableDrivers.forEach(d -> {
//if(d.getCab().getStatus().equals(BookingStatus.AVAILABLE)) {
//	Integer[] driverCurrLocation= d.getDriverCurrentPosition();
//	driverCurrLocation[0] = x;
//	driverCurrLocation[1]=y;
//	
//	Integer[] userCurrLocation=user.getCurrentPosition();
//	userCurrLocation[0]=x;
//	userCurrLocation[1]=y;
//	
//	cab.setDriver(d);
//	cab.setCabNumber(d.getCab().getCabNumber());
//	cab.setCabType(d.getCab().getCabType());
////	cab.setStatus(BookingStatus.BOOKED);
//	bool++;
//}
//if(bool>0) return;
//});
