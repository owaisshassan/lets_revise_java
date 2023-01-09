package com.owaiss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.owaiss.exception.UserException;
import com.owaiss.exception.WalletException;
import com.owaiss.model.Transaction;
import com.owaiss.model.User;
import com.owaiss.model.Wallet;
import com.owaiss.service.UserWalletService;

@RestController
public class UserWalletController {
	
	@Autowired
	private UserWalletService userWalletService; 
	
	
//   http://localhost:8888/add/users
	@PostMapping("/add/user")
	public ResponseEntity<User> addUser_Handler(@Valid @RequestBody User user) throws UserException{
		User addedUser= userWalletService.addUser(user);
		
		
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);
	}
	
	
	
//  http://localhost:8888/delete/users/userId	
	@DeleteMapping("/delete/users/{id}")
	public ResponseEntity<User> deleteUser_Handler(@PathVariable("id") int id, @RequestParam String key)
			throws UserException{
		
		User delUser = userWalletService.deleteUser(id,key);
		
		return new ResponseEntity<User>(delUser, HttpStatus.OK) ;
	}
	
	
	
//  http://localhost:8888/wallet/balance/userId
	@GetMapping("wallet/balance/{userId}")
	public ResponseEntity<String> checkCurrentBalance_Handler(@Valid @PathVariable("userId") Integer userId,
			@RequestParam String key) 
					throws UserException, WalletException{
		
		String curr_balance= userWalletService.check_Current_Balance(userId, key);
		
		return new ResponseEntity<String>(curr_balance,HttpStatus.OK);
	}
	
//  http://localhost:8888/wallet/balance/add/userId/amount
	@PutMapping("wallet/balance/add/{userId}/{amount}")
	public ResponseEntity<String> addMoney_Handler(@Valid @PathVariable("userId") Integer userId,
			@RequestParam String key,@PathVariable("amount") long amount) 
					throws UserException, WalletException{
		
		String addedMoney= userWalletService.add_Money(userId, key, amount);
		
		return new ResponseEntity<String>(addedMoney,HttpStatus.OK);
	}
	
	
//  http://localhost:8888/wallet/balance/withdraw/userId/amount
	@PutMapping("wallet/balance/withdraw/{userId}/{amount}")
	public ResponseEntity<String> withdrawMoney_Handler(@Valid @PathVariable("userId") Integer userId,
			@RequestParam String key,@PathVariable("amount") long amount)
					throws UserException, WalletException{
		
		String withdrawnMoney= userWalletService.withdraw_Money(userId, key, amount);
		
		return new ResponseEntity<String>(withdrawnMoney,HttpStatus.OK);
	}
	
	
//  http://localhost:8888/wallet/transactions/userId
	@GetMapping("wallet/transactions/{userId}")
	public ResponseEntity<List<Transaction>> checkTransactionHistory_Handler(@Valid @PathVariable("userId") 
			Integer userId,@RequestParam String key) throws UserException, WalletException{
		
		List<Transaction> all_transactions = userWalletService.check_Transaction_History(userId, key);
		
		return new ResponseEntity<List<Transaction>>(all_transactions,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
