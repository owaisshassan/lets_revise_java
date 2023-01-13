package com.owaiss.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.owaiss.model.User;
import com.owaiss.repository.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userDao;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> opt= userDao.findByUserName(username);
		
		if(opt.isPresent()) {
			return new MyUserDetails(opt.get());
		}else {
			throw new UsernameNotFoundException("UserName not found!");
		}
		
	}

}
