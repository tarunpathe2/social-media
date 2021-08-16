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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String postName;
	
	@Column
	private String details;
	
	@Column
	private Date createdDate;
	
	@Column
	private Date updatedDate;
	
	@Column
	private long totalLikes;
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comments> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
	private List<Tags> tags = new ArrayList<>();
	
	@OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
	private List<Likes> likes= new ArrayList<>();

	public Post() {
		super();
	}

	public Post(long id, String postName, String details, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.postName = postName;
		this.details = details;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		
	}
	



	public List<Likes> getLikes() {
		return likes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(long totalLikes) {
		this.totalLikes = totalLikes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}
	
	
	
}
