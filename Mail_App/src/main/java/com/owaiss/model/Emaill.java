package com.owaiss.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Emaill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emailId;
	
	private String email;
}
