package com.boot.rest.user.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.rest.user.Post;
import com.boot.rest.user.User;
import com.boot.rest.user.repository.PostRepository;
import com.boot.rest.user.repository.UserRepository;

@RestController
public class PostController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveUserPost(@PathVariable long id) 
	{
		 Optional<User> userOptional = userRepository.findById(id);		 
		 return userOptional.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public Post createPost(@PathVariable long id, @RequestBody Post post)
	{
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		post.setUser(user);
		post.setCreatedDate(new Date());
		Post savedPost = postRepository.save(post);
		return savedPost;
		
	}
	
	@PutMapping("/users/{id}/posts")
	public Post updatePost(@PathVariable long id, @RequestBody Post post)
	{
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		post.setUser(user);
		post.setUpdatedDate(new Date());
		Post savedPost = postRepository.save(post);
		return savedPost;
		
	}
	
	@DeleteMapping("/users/posts/{postId}")
	public void deletePost(@PathVariable Long postId)
	{
		postRepository.deleteById(postId);
	}

}
