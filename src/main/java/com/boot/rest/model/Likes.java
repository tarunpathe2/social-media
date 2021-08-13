package com.boot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long totalLikes;
	
	@ManyToOne
	@JsonBackReference
	private Post post;
	
	@OneToOne
	@JsonBackReference
	private User user;
	
	public Likes() {
		super();
	}

	public Likes(long id, long totalLikes) {
		super();
		this.id = id;
		this.totalLikes = totalLikes;
	}

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
