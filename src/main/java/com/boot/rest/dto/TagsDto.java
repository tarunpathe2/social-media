package com.boot.rest.dto;

import com.boot.rest.model.Post;

public class TagsDto {
	
	private long id;
	
	private String name;
	
	private Post post;

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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
