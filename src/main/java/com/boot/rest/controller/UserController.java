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


import com.boot.rest.dto.UserDto;
import com.boot.rest.model.Post;
import com.boot.rest.model.User;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.service.serviceImpl.UserServiceImpl;
import com.boot.rest.util.Response;


@RestController
@RequestMapping("/social-media/")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("addUser")
	public Response<String> addUser(@RequestBody UserDto userDto) {
		return new Response<String>(HttpStatus.OK.value(),"User Added Succeessfully");
	}
	
	@GetMapping("getAllUsers")
	public Response<List<UserDto>> getAllUsers() {
		return new Response<List<UserDto>>(HttpStatus.OK.value(),service.getAllUsers());
	}
	
	@GetMapping("getUser/{email}")
	public Response<UserDto> getUser(@PathVariable String email) {
		return new Response<UserDto>(HttpStatus.OK.value(),service.getUser(email));
	}
	
	@DeleteMapping("deleteUser/{email}")
	public Response<UserDto> deleteUser(@PathVariable UserDto userDto) {
		return new Response<UserDto>(HttpStatus.OK.value(),service.deleteUser(userDto));
	} 
}
