package com.boot.rest.dto;

import org.springframework.lang.NonNull;

import com.boot.rest.model.Post;

public class TagsDto {
	
	private long id;
	
	private String name;
	
	@NonNull
	private Long postId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}
