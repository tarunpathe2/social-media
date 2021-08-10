package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.boot.rest.model.Comments;
import com.boot.rest.model.Tags;
import com.boot.rest.model.User;

public class PostDto {
	private long Id;
	private String postName;  
	private String details;
	private Long like;
	private Date createdDate;
	private Date updatedDate;
	private User user;    
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
	public List<Tags> getTag() {
		return tag;
	}
	public void setTag(List<Tags> tag) {
		this.tag = tag;
	}
	public PostDto(long id, String postName, String details, Long like, Date createdDate, Date updatedDate, User user,
			List<Comments> comments, List<Tags> tag) {
		super();
		Id = id;
		this.postName = postName;
		this.details = details;
		this.like = like;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.user = user;
		this.comments = comments;
		this.tag = tag;
	}
	public PostDto() {
		super();
	}
	@Override
	public String toString() {
		return "PostDto [Id=" + Id + ", postName=" + postName + ", details=" + details + ", like=" + like
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", user=" + user + ", comments="
				+ comments + ", tag=" + tag + "]";
	}
	
	
}
