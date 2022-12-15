package com.owaiss.model;




import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

	@Id
	private Integer driverId;
	
	@NotNull(message = "Driver name cannot be null")
	private String name;
	
	@NotNull(message = "position coordinates cannot be null")
	@Size(min = 2,max = 2,message = "please provide 2 position coordinates : 'x' and 'y'")
	private Integer[] driverCurrentPosition;
	

	
	
	@OneToOne
	private Cab cab;

	@OneToOne(mappedBy = "driver")
	private User user;


	public Driver(
			@NotNull(message = "position coordinates cannot be null") @Size(min = 2, max = 2, message = "please provide 2 position coordinates : 'x' and 'y'") Integer[] driverCurrentPosition,
			Cab cab) {
		super();
		this.driverCurrentPosition = driverCurrentPosition;
		this.cab = cab;
	}




	public Driver(@NotNull(message = "Driver name cannot be null") String name,
			@NotNull(message = "position coordinates cannot be null") @Size(min = 2, max = 2, message = "please provide 2 position coordinates : 'x' and 'y'") Integer[] driverCurrentPosition,
			Cab cab) {
		super();
		this.name = name;
		this.driverCurrentPosition = driverCurrentPosition;
		this.cab = cab;
	}




	public Driver(@NotNull(message = "Driver name cannot be null") String name,
			@NotNull(message = "position coordinates cannot be null") @Size(min = 2, max = 2, message = "please provide 2 position coordinates : 'x' and 'y'") Integer[] driverCurrentPosition,
			Cab cab, User user) {
		super();
		this.name = name;
		this.driverCurrentPosition = driverCurrentPosition;
		this.cab = cab;
		this.user = user;
	}
	
	
	
	


	
	


	
	
	
}
