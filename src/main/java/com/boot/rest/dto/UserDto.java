package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.lang.NonNull;

import com.boot.rest.model.Post;

public class UserDto {
	
	
	private long id;

	private String name;

	private String email;
	
	private Date dateOfBirth;
	
	private String address;
	
	private List<Post> posts = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public UserDto() {
		super();
	}

	public UserDto(long id, String name, String email, Date dateOfBirth, String address, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", posts=" + posts + "]";
	}
	
	


}
