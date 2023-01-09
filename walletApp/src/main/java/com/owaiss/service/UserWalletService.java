package com.owaiss.service;

import java.util.List;




import com.owaiss.exception.UserException;
import com.owaiss.exception.WalletException;
import com.owaiss.model.Transaction;
import com.owaiss.model.User;
import com.owaiss.model.Wallet;


public interface UserWalletService {

	
	public User addUser(User user) throws UserException;
		
	public User deleteUser(int userId,String key) throws UserException;
	
	public String check_Current_Balance(int userId,String key) throws UserException,WalletException;
	
	public String add_Money(int userId,String key,long amount) throws UserException,WalletException;
	
	public String withdraw_Money(int userId,String key,long amount) throws UserException,WalletException;
	
	public List<Transaction> check_Transaction_History(int userId,String key) throws UserException,WalletException;
	
}
