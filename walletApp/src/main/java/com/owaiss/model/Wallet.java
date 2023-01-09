package com.owaiss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wallet_id;
	
	@Min(message = "wallet_balance cannot be less than zero", value = 0)
	private long wallet_balance;
	
	@OneToMany
	private List<Transaction> transactions;

	
	public Wallet(@Min(message = "wallet_balance cannot be less than zero", value = 0) long wallet_balance) {
		super();
		this.wallet_balance = wallet_balance;
	}
	

	public Wallet(@Min(message = "wallet_balance cannot be less than zero", value = 0) long wallet_balance,
			List<Transaction> transactions) {
		super();
		this.wallet_balance = wallet_balance;
		this.transactions = transactions;
	}

	
	
	
	
	
	
}
