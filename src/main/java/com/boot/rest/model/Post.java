package com.boot.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	@NonNull
	private String postName;
	@Column
	@NonNull
	private String details;
	@Column
	private Long like;
	@Column
	private Date createdDate;
	@Column
	private Date updatedDate;
	@ManyToOne
	@JoinColumn(name = "users_id",nullable = false)
	@JsonBackReference
	private User user;
	/*
	 * @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
	 * 
	 * @JsonManagedReference private List<Comments> comments = new ArrayList<>();
	 */
	
	/*
	 * @OneToMany(mappedBy = "postModel",fetch = FetchType.LAZY)
	 * 
	 * @JsonManagedReference private List<Tags> tag = new ArrayList<>();
	 */
	
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

	/*
	 * public List<Comments> getComments() { return comments; } public void
	 * setComments(List<Comments> comments) { this.comments = comments; }
	 */
	public Post(long id, String postName, String details, Long like, Date createdDate, Date updatedDate) {
		super();
		Id = id;
		this.postName = postName;
		this.details = details;
		this.like = like;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public Post() {
		super();
	}
	
	
	
	

}
