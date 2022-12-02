package com.owaiss.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue
	private int postId;
	private int likes;
	private String title;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comment;
	
	@ManyToOne
	private Customer customer;

	public Post(int likes, String title, List<Comment> comment, Customer customer) {
		super();
		this.likes = likes;
		this.title = title;
		this.comment = comment;
		this.customer = customer;
	}

	
	
}
