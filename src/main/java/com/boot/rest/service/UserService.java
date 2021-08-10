package com.boot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.exception.UnprocessableEntity;
import com.boot.rest.model.User;
import com.boot.rest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public String addUser(User user) {
		Optional<User> userModel = repo.findByEmail(user.getEmail());
		if(userModel.isPresent())
			throw new UnprocessableEntity("Email already Exist");
		else
			repo.save(user);
		return user.getEmail();
	}

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	
	public String getUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		if(!user.isPresent())
			throw new DataNotFoundException("Data Not found");
		else
			return user.toString();
	}

	public String deleteUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		if(!user.isPresent())
			throw new DataNotFoundException("Data Not found");
		else
			return email;
	}
}
