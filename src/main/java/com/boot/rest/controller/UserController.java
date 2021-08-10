package com.boot.rest.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.rest.model.Post;
import com.boot.rest.model.User;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.response.Response;
import com.boot.rest.service.UserService;


@RestController
@RequestMapping("/social-media/")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("addProfile")
	public Response<String> addUser(@RequestBody User user) {
		return new Response<String>(HttpStatus.OK.value(),service.addUser(user),"User Added Succeessfully",null);
	}
	
	@GetMapping("getAllProfiles")
	public Response<List<User>> getAllUsers() {
		return new Response<List<User>>(HttpStatus.OK.value(),service.getAllUsers(),"get All Users",null);
	}
	
	@GetMapping("getProfile/{email}")
	public Response<String> getUser(@PathVariable String email) {
		return new Response<String>(HttpStatus.OK.value(),service.getUser(email),"User",null);
	}
	
	@GetMapping("deleteProfile/{email}")
	public Response<String> deleteUser(@PathVariable String email) {
		return new Response<String>(HttpStatus.OK.value(),service.deleteUser(email),"delete User",null);
	} 
}
