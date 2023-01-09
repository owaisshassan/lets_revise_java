package com.owaiss.service;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.UserException;
import com.owaiss.exception.WalletException;
import com.owaiss.model.CurrentUserSession;
import com.owaiss.model.Transaction;
import com.owaiss.model.User;
import com.owaiss.model.Wallet;
import com.owaiss.repository.CurrentUserSessionRepo;
import com.owaiss.repository.TransactionRepo;
import com.owaiss.repository.UserRepo;
import com.owaiss.repository.WalletRepo;



@Service
public class UserWalletServiceImpl implements UserWalletService{

	@Autowired
	private UserRepo userDao;
	

	@Autowired
	private CurrentUserSessionRepo cusDao;
	
	@Autowired
	private WalletRepo walletDao;
	
	@Autowired
	private TransactionRepo tDao;
	//List<String> transactionHistory = new ArrayList<>();
	
	@Override
	public User addUser(User user) throws UserException {
		
			User us= userDao.findByContact(user.getContact());
			
			if(us!=null) {
				throw new UserException("User already exists!");
			}else {
				Wallet newWallet =new Wallet(0);
				
				walletDao.save(newWallet);
				user.setWallet(newWallet);
				userDao.save(user);
				
				return user;
			}
		
		
	}

	

	@Override
	public User deleteUser(int userId, String key) throws UserException{
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please check key, No User loggedIn with given key");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			userDao.deleteById(userId);
			
			User u= opt.get();
			return u;
		}else {
			throw new UserException("User Not Found!");
		}
		
	}



	






	@Override
	public String check_Current_Balance(int userId, String key) throws UserException, WalletException {
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please check key, No User loggedIn with given key");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			User u= opt.get();
			Wallet w=u.getWallet();
			if(w == null) {
				throw new WalletException("No Wallet found for this user!");
			}else return "Current balance : " + w.getWallet_balance();
		}else {
			throw new UserException("User Not Found!");
		}
	}



	@Override
	public String add_Money(int userId, String key, long amount) throws UserException, WalletException {
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please check key, No User loggedIn with given key");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			User u= opt.get();
			Wallet w=u.getWallet();
			if(w == null) {
				throw new WalletException("No Wallet found for this user!");
			}else { 
				
				w.setWallet_balance(w.getWallet_balance()+amount);
				Transaction t= new Transaction("Money added! : < "+amount+" >", LocalDate.now());
				tDao.save(t);
				w.getTransactions().add(t);
				walletDao.save(w);
				long current_balance = w.getWallet_balance();
				
				
				
				return "Money added successfully! --> Current balance is "+ current_balance;   
			}
		}else {
			throw new UserException("User Not Found!");
		}
	}



	@Override
	public String withdraw_Money(int userId, String key, long amount) throws UserException, WalletException {
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please check key, No User loggedIn with given key");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			User u= opt.get();
			Wallet w=u.getWallet();
			if(w == null) {
				throw new WalletException("No Wallet found for this user!");
			}else { 
				if(w.getWallet_balance() > amount) {
					 w.setWallet_balance(w.getWallet_balance()-amount);
					 Transaction t= new Transaction("Money withdrawn : < "+amount+" >", LocalDate.now());
					 tDao.save(t);
					 w.getTransactions().add(t);
					 
					 walletDao.save(w);
					 long current_balance = w.getWallet_balance();
						
					
					 
					return "Money withdrawn successfully! --> Current balance is "+ current_balance;   
				}else throw new WalletException("Not enough balance!");
			}
		}else {
			throw new UserException("User Not Found!");
		}
	}



	@Override
	public List<Transaction> check_Transaction_History(int userId, String key) throws UserException, WalletException {
		CurrentUserSession loggedInUser= cusDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please check key, No User loggedIn with given key");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			User u= opt.get();
			List<Transaction> transactions = u.getWallet().getTransactions();
			if(transactions.size() == 0) throw new WalletException("No Transaction history found!");
			return transactions;
		}else {
			throw new UserException("User Not Found!");
		}
	}

	

}
