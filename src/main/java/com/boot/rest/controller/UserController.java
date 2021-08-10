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
import com.boot.rest.service.UserService;


@RestController
@RequestMapping("/social-media/")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("addProfile")
	public UserDto addUser(@RequestBody UserDto userDto) {
		return service.addUser(userDto);
	}
	
	@GetMapping("getAllProfiles")
	public List<UserDto> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("getProfile/{email}")
	public String getUser(@PathVariable String email) {
		return service.getUser(email);
	}
	
	@GetMapping("deleteProfile/{email}")
	public String deleteUser(@PathVariable String email) {
		return service.deleteUser(email);
	} 
}
