package com.owaiss.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {
	
	@javax.persistence.Id
	@Column(unique = true)
	private String email;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	

	
	
	

}
