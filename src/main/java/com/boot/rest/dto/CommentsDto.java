package com.boot.rest.dto;

import com.boot.rest.model.Post;

public class CommentsDto {

	private long id;
	private String message;  
	private Post post;
	
	public CommentsDto(long id, String message, Post post) {
		super();
		this.id = id;
		this.message = message;
		this.post = post;
	}
	
	public CommentsDto() {
		super();
	}

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

	@Override
	public String toString() {
		return "CommentsDto [id=" + id + ", message=" + message + ", post=" + post + "]";
	}
	
	
	
}
