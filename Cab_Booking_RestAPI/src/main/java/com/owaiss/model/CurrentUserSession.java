package com.owaiss.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private String contact;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	public CurrentUserSession(String uuid, LocalDateTime localDateTime) {
		super();
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	
	

	
	
	

}
