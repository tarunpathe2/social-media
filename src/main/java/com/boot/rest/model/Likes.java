package com.boot.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
@IdClass(Likes.class)
public class Likes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long postId;

	@Id
	@Column
	private Long userId;

	public Likes() {
		super();
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Likes(Long postId, Long userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Likes [postId=" + postId + ", userId=" + userId + "]";
	}

}
