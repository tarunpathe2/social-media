package com.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.dto.UserDto;
import com.boot.rest.service.UserService;
import com.boot.rest.util.Response;


@RestController
@RequestMapping("/social-media/")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("addUser")
	public Response<String> addUser(@RequestBody UserDto userDto) {
		return new Response<String>(HttpStatus.OK.value(),service.addUser(userDto));
	}
	
	@GetMapping("getAllUsers")
	public Response<List<UserDto>> getAllUsers() {
		System.out.println("Get User Request ");
		return new Response<List<UserDto>>(HttpStatus.OK.value(),service.getAllUsers());
	}
	
	@GetMapping("getUser/{email}")
	public Response<UserDto> getUser(@PathVariable String email) {
		return new Response<UserDto>(HttpStatus.OK.value(),service.getUser(email));
	}
	
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity deleteUser(@PathVariable long id) {
		service.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
}
