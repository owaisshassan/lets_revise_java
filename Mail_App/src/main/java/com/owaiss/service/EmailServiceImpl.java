package com.owaiss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.EmailException;
import com.owaiss.exception.UserException;
import com.owaiss.model.Emaill;
import com.owaiss.model.User;

import com.owaiss.repository.EmailRepo;
import com.owaiss.repository.UserRepo;

@Service
public class EmailServiceImpl implements EmailService{
	
	
	
	@Autowired
	private EmailRepo emailDao;
	
	@Autowired
	private UserRepo userDao;

	@Override
	public String sendMail(Emaill email) throws EmailException, UserException {
		User u= userDao.findByEmail(email.getEmail());
		 if(u!=null) {
			 return "Mail sent successfully!";
		 }else {
			 throw new EmailException("email not found!");
		 }
	}

	public static String str="";
	@Override
	public String starMail(Integer emailID) throws EmailException, UserException {
		
		
		Optional<Emaill> maill= emailDao.findById(emailID);
		if(maill.isPresent()) {

			List<User> allUsers= userDao.findAll();
			allUsers.forEach(u ->{
				
				List<Emaill> allMails = u.getAllMails();
				allMails.forEach(mail -> {
					if(mail.getEmailId() == emailID) {
						u.getStarredMails().add(mail);
						userDao.save(u);
						String s= "Starred successfully!";
						str+=s;
						
					}
				});
			});
		}else {
			throw new EmailException("No email found!");
		}
		if(str.length()==0) {
			return "Not starred";
		}else {
			return str;
		}
	}
	
	public static String delStr="";

	@Override
	public String deleteMail(Integer emailID) throws EmailException, UserException {

		Optional<Emaill> maill= emailDao.findById(emailID);
		if(maill.isPresent()) {

			List<User> allUsers= userDao.findAll();
			allUsers.forEach(u ->{
				List<Emaill> allMails= u.getAllMails();
				allMails.forEach(mail -> {
					if(mail.getEmailId() == emailID) {
						allMails.remove(mail);
						emailDao.delete(mail);
						String s= "deleted successfully!";
						delStr+=s;
						
					}
				});
			});
		}else {
			throw new EmailException("No email found!");
		}
		if(str.length()==0) {
			return "Not starred";
		}else {
			return delStr;
		}
	}

}
