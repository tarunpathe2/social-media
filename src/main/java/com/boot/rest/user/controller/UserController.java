package com.boot.rest.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.rest.user.Post;
import com.boot.rest.user.User;
import com.boot.rest.user.repository.PostRepository;
import com.boot.rest.user.repository.UserRepository;



@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return userRepository.findAll();
		 
	}
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable long id) throws Exception
	{
		 Optional<User> user = userRepository.findById(id);
		 if(!user.isPresent())
			 throw new Exception("id-"+id);
		 
		 return user;
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id)
	{
		 userRepository.deleteById(id);
		 
	
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		
		 User savedUser = userRepository.save(user);
		 			/*
			 * post.setUser(user.get()); postRepository.save(post);
			 */
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveUserPost(@PathVariable long id) throws Exception
	{
		 Optional<User> userOptional = userRepository.findById(id);
		 if(!userOptional.isPresent())
			 throw new Exception("id-"+id);
		 
		 return userOptional.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Post post) throws Exception
	{
		Optional<User> userOptional = userRepository.findById(id);
		 if(!userOptional.isPresent())
			 throw new Exception("id-"+id);
		
		 User user = userOptional.get();
		 
		 
		 post.setUser(user); 
		 postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostName()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
