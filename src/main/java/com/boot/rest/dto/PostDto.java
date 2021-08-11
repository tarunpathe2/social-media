package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.boot.rest.model.Comments;
import com.boot.rest.model.Tags;
import com.boot.rest.model.User;

public class PostDto {

	private long Id;

	@NonNull
	private String postName;
	
	@NonNull
	private String details;
	
	private Long like;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	private Optional<User> user;
	
	private List<Comments> comments = new ArrayList<>();
	
	private List<Tags> tag = new ArrayList<>();

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

	public Long getLike() {
		return like;
	}

	public void setLike(Long like) {
		this.like = like;
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

	public Optional<User> getUser() {
		return user;
	}

	public void setUser(Optional<User> user2) {
		this.user = user2;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Tags> getTag() {
		return tag;
	}

	public void setTag(List<Tags> tag) {
		this.tag = tag;
	}

}
