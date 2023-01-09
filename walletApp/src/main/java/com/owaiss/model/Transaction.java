package com.owaiss.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transaction_id;
	private String message;
//	private Color color;
	private LocalDate timeStamp;
	
	
	public Transaction(String message, LocalDate timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
		
	
	
	

	
	
}
