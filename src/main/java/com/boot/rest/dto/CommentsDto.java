package com.boot.rest.dto;

import org.springframework.lang.NonNull;

public class CommentsDto {

	private long id;
	
	private String message;  
	
	@NonNull
	private Long userId;
	
	@NonNull
	private Long postId;
	
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}
