package com.owaiss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.owaiss.exception.DriverException;
import com.owaiss.model.Driver;
import com.owaiss.repository.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepo driverDao;
	
	
	
	//This will create an instance of the driver and will mark his current location on the map
	@Override
	public Driver add_driver(Driver driver) throws DriverException {
		
		Optional<Driver> dOpt= driverDao.findById(driver.getDriverId());
		
		if(dOpt.isPresent()) throw new DriverException("Driver already exists with id: "+driver.getDriverId());
		
		driverDao.save(driver);
		
		
		return driver;
	}

}
