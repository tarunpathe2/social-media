package com.boot.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;

public class UserProfileDto {

	private long id;
	
	private String name;
	
	private Date dateOfBirth;
	
	private String address;
	
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}
