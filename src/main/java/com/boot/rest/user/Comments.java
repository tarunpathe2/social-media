package com.boot.rest.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Comments {

	@Id
	private long c_id;
	private String comments;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comments [c_id=" + c_id + ", comments=" + comments + "]";
	}
	public Comments(long c_id, String comments, User user, Post post) {
		super();
		this.c_id = c_id;
		this.comments = comments;
		this.user = user;
		this.post = post;
	}
	public Comments() {
		super();
	}
	
	
	
	
}
