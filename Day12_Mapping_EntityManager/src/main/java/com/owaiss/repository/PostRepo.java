package com.owaiss.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.owaiss.entity.Comment;
import com.owaiss.entity.Customer;
import com.owaiss.entity.Post;

@Repository
public class PostRepo {

	@Autowired
	EntityManager em;
	
	public Customer findPostCustomer(int id) {
		return em.find(Customer.class, id);
	}
	
	public String findPostTitleByID(int postId) {
		Post p= em.find(Post.class, postId);
		
		return p.getTitle();
	}
	
	public int findNumOfLikes(int postId) {
		Post p= em.find(Post.class, postId);
		
		return p.getLikes();
	}
	
	
	public List<Comment> findAllComments(int postId){
		Post p= em.find(Post.class, postId);
		
		return p.getComment();
	}
}
