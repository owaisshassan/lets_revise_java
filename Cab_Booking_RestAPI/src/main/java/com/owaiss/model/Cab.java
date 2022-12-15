package com.owaiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabNumber;
	private String cabType;
	
	private BookingStatus status;
	
	@OneToOne(mappedBy = "cab")
	private Driver driver;
	

	public Cab(String cabType, BookingStatus status, Driver driver) {
		super();
		this.cabType = cabType;
		this.status = status;
		this.driver = driver;
	}

	
	
}
