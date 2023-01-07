package com.owaiss.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.Data;

@Data
@Entity
public class Email {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mail_id;
	
	@jakarta.validation.constraints.Email
	private String email;
	private LocalDate created_date;
	
	@OneToOne
	private User user;
}
