package com.owaiss.service;


import com.owaiss.exception.DriverException;
import com.owaiss.model.Driver;

public interface DriverService {

	public Driver add_driver(Driver driver) throws DriverException;
}
