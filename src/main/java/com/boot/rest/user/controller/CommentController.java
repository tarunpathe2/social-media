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

import com.boot.rest.user.Comments;
import com.boot.rest.user.Post;
import com.boot.rest.user.User;
import com.boot.rest.user.repository.CommentRepository;
import com.boot.rest.user.repository.PostRepository;
import com.boot.rest.user.repository.UserRepository;

@RestController
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/users/posts/{postId}/comments/")
	public List<Comments> retrieveUserPost(@PathVariable long postId) 
	{
		 Optional<Post> postOptional = postRepository.findById(postId);		 
		 return postOptional.get().getComments();
	}
	
	@PostMapping("/users/{id}/posts/{postId}/comments")
	public Comments createComments(@PathVariable long id,@PathVariable long postId, @RequestBody Comments comments)
	{
		Optional<User> userOptional = userRepository.findById(id);
		Optional<Post> postOptional = postRepository.findById(postId);

		User user = userOptional.get();
		Post post = postOptional.get();
		comments.setPost(post);
		comments.setUser(user);
		Comments savedComment = commentRepo.save(comments);
		return savedComment;
		
	}
	
	/*
	 * @PutMapping("/users/{id}/posts/{postId}/comments") public Comments
	 * updateComments(@PathVariable long id,@PathVariable long postId, @RequestBody
	 * Comments comments) { Optional<User> userOptional =
	 * userRepository.findById(id); Optional<Post> postOptional =
	 * postRepository.findById(postId);
	 * 
	 * User user = userOptional.get(); Post post = postOptional.get();
	 * comments.setPost(post); comments.setUser(user); Comments savedComment =
	 * commentRepo.save(comments); return savedComment;
	 * 
	 * }
	 */
	
	@DeleteMapping("/users/comments/")
	public void deletePost(@PathVariable Long c_id)
	{
		postRepository.deleteById(c_id);
	}


}
