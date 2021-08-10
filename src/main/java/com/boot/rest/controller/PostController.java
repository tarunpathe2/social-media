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
import com.boot.rest.service.PostService;

@RestController
@RequestMapping("/social-media/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("user/{id}/post")
	public Response<Post> addPost(@Validated @PathVariable Long id, @RequestBody Post post) {
		return new Response<Post>(HttpStatus.OK.value(),postService.addPost(id,post),"Post Added Successfully",null);
	}
	@PostMapping("user/{uId}/post/{pId}/update")
	public Response<Post> addPost(@Validated @PathVariable Long uId, @PathVariable Long pId,@RequestBody Post model) {
		return new Response<Post>(HttpStatus.OK.value(),postService.updateUserPost(uId,pId,model),"Post Updated Successfully",null);
	}
	@GetMapping("user/{id}/getPosts")
	public Response<List<Post>> getPost(@PathVariable Long id) {
		return new Response<List<Post>>(HttpStatus.OK.value(),postService.getPosts(id),"List All Posts",null);
	}

	@GetMapping("getAllPosts")
	public Response<List<Post>> getAllPost() {
		return new Response<List<Post>>(HttpStatus.OK.value(),postService.getAllPosts(),"List All Posts",null);
	}
	@GetMapping("post/{id}/like")
	public Response<String> like(@PathVariable Long id) {
		return new Response<String>(HttpStatus.OK.value(),postService.like(id),"Like your post",null);
	}
	
	@GetMapping("user/{uId}/post/{pId}")
	public Response<String> deletePost(@PathVariable Long uId,@PathVariable Long pId) {
		return new Response<String>(HttpStatus.OK.value(),postService.deleteUserPost(uId,pId),"user post deleted",null);
	}

}