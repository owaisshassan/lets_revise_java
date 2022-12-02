package com.owaiss.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.owaiss.entity.Customer;
import com.owaiss.entity.Post;

@Repository
public class CustomerRepo {
	
	
	@Autowired
	 EntityManager em;
	
	
//	public Customer createCustomer(Customer customer) {
//		if(customer.getId() == null) em.persist(customer);
//		else em.merge(customer);
//		
//		return customer;
//	}

	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}
	
	public String findCustomerNameByID(int id) {
		Customer c= em.find(Customer.class, id);
		
		return c.getName();
	}
	
	
	public List<Post> getPosts(int id){
		Customer c= em.find(Customer.class, id);
		
		List<Post> posts= c.getPost();
		
		return posts;
	}
	
	
	
	
}
