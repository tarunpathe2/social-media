package com.boot.rest.dto;

import org.springframework.lang.NonNull;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;

public class LikesDto {

	private long id;
	
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
