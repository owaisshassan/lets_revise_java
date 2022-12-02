package com.owaiss.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.owaiss.entity.Comment;
import com.owaiss.entity.Post;

@Repository
public class CommentRepo {

	@Autowired
	EntityManager em;
	
	public String getCommentPublisherName(int id) {
		Comment c= em.find(Comment.class, id);
		
		return c.getCommentHolder();
	}
	
	public String getCommentDesc(int id) {
		Comment c= em.find(Comment.class, id);
		
		return c.getCommentDesc();
	}
	
	public Post getPostByCommentID(int id) {
		Comment c= em.find(Comment.class, id);
		
		return c.getPost();
	}
	
	
}
