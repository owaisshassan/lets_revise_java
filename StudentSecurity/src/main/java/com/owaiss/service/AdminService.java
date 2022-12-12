package com.owaiss.service;

import java.util.List;

import com.owaiss.exception.AdminException;
import com.owaiss.exception.StudentException;
import com.owaiss.model.Admin;
import com.owaiss.model.Student;

public interface AdminService {

	public Admin registerAdmin(Admin admin)throws AdminException;
	
}
