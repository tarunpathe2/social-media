package com.boot.rest.dto;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;

public class LikesDto {

	private long id;
	
	private long totalLikes;
	
	private Post post;
	
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(long totalLikes) {
		this.totalLikes = totalLikes;
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
