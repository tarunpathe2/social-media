package com.boot.rest.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "user",cascade =  CascadeType.ALL)
	@JsonManagedReference
	private UserProfile userProfile;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
	@JsonManagedReference
	private List<Post> post = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Comments> comments = new ArrayList<>();
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
	@JsonManagedReference
	private Likes likes;
	
	public User() {
		super();
	}

	public User(long id, String email,UserProfile userProfile) {
		super();
		this.id = id;
		this.email = email;
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

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

}
