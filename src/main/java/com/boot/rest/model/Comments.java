package com.boot.rest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
/*
 * @Entity public class Comments {
 * 
 * @Id private long id; private String message;
 * 
 * @JoinColumn(name = "post_id",nullable = false)
 * 
 * @JsonBackReference
 * 
 * @ManyToOne private Post post;
 * 
 * public Comments() { super(); }
 * 
 * public Comments(long id, String message, Post post) { super(); this.id = id;
 * this.message = message; this.post = post; }
 * 
 * public long getId() { return id; }
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * public String getMessage() { return message; }
 * 
 * public void setMessage(String message) { this.message = message; }
 * 
 * public Post getPost() { return post; }
 * 
 * public void setPost(Post post) { this.post = post; }
 * 
 * @Override public String toString() { return "Comments [id=" + id +
 * ", message=" + message + ", post=" + post + "]"; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */