package com.boot.rest.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.rest.dto.PostDto;
import com.boot.rest.model.Post;
import com.boot.rest.model.User;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.util.*;
import com.boot.rest.service.PostService;

@RestController
@RequestMapping("/social-media/")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("user/post")
	public Response<PostDto> addPost(@RequestBody PostDto post) {
		return new Response<PostDto>(HttpStatus.OK.value(), postService.addPost(post));
	}

	@GetMapping("user/getPost/{id}")
	public Response<PostDto> getPost(@PathVariable Long id) {
		return new Response<PostDto>(HttpStatus.OK.value(), postService.getPost(id));
	}

	@PutMapping("user/post")
	public Response<PostDto> updatePost(@RequestBody PostDto postDto) {
		return new Response<PostDto>(HttpStatus.OK.value(), postService.updateUserPost(postDto));
	}

	@GetMapping("getAllPosts")
	public Response<List<PostDto>> getAllPost() {
		return new Response<List<PostDto>>(HttpStatus.OK.value(), postService.getAllPosts());
	}

	@DeleteMapping("user/post/{id}")
	public Response<PostDto> deletePost(@PathVariable Long id) {
		return new Response<PostDto>(HttpStatus.OK.value(), postService.deleteUserPost(id));
	}

}
