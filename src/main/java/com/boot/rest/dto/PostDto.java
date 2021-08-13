package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.boot.rest.model.Comments;
import com.boot.rest.model.Likes;
import com.boot.rest.model.Tags;
import com.boot.rest.model.User;

public class PostDto {

	private long Id;

	private String postName;
	
	private String details;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	private User user;
	
	private List<Comments> comments = new ArrayList<>();
	
	private List<Tags> tags = new ArrayList<>();
	
	private Likes likes;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	
	
}
