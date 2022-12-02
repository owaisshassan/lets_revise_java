package com.owaiss.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "customer")
	private List<Post> post;

	public Customer(String name, List<Post> post) {
		super();
		this.name = name;
		this.post = post;
	}
	
	
	

}
