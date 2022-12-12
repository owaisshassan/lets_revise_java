package com.owaiss.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.AdminException;
import com.owaiss.model.Admin;
import com.owaiss.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminDao;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminOpt= adminDao.findById(admin.getAdminId());
		if(adminOpt.isPresent()){
			throw new AdminException("Admin already exists with this Admin ID");
		}else {
			adminDao.save(admin);
			return admin;
		}
	}

}
