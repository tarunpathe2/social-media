package com.boot.rest.service;

import java.util.List;

import com.boot.rest.dto.PostDto;

public interface PostService {

	public PostDto addPost(PostDto postDto);
	public List<PostDto> getAllPosts();
	public PostDto getPost(long id);
	public PostDto updateUserPost(PostDto postDto);
	public void deleteUserPost(long id);
}
