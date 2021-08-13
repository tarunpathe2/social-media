package com.boot.rest.dto;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;

public class CommentsDto {

	private long id;
	
	private String message;  
	
	private User user;
	
	private Post post;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
