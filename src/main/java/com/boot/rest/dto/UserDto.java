package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.boot.rest.model.Comments;
import com.boot.rest.model.Likes;
import com.boot.rest.model.Post;
import com.boot.rest.model.UserProfile;

public class UserDto {

	private long id;
	
	private String email;
	
	private UserProfile userProfile;
	
	private List<Post> post = new ArrayList<>();
	
	private List<Comments> comments = new ArrayList<>();
	
	private Likes likes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	
}
