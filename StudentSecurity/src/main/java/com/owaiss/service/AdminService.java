package com.owaiss.service;

import com.owaiss.exception.AdminException;
import com.owaiss.model.Admin;

public interface AdminService {

	public Admin registerAdmin(Admin admin)throws AdminException;
}
