package com.owaiss.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	private String commentHolder;
	private String commentDesc;
	
	@ManyToOne
	private Post post;

	public Comment(String commentDesc, Post post,String commentHolder) {
		super();
		this.commentDesc = commentDesc;
		this.post = post;
		this.commentHolder=commentHolder;
	}
	
	
	
	
}
