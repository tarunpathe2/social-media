package com.boot.rest.service;

import java.util.List;

import com.boot.rest.dto.PostDto;
import com.boot.rest.dto.UserDto;
import com.boot.rest.model.Post;
import com.boot.rest.util.Response;

public interface PostService {

	public PostDto addPost(PostDto postDto);
	public List<PostDto> getAllPosts();
	public PostDto getPost(long id);
	public List<PostDto> getUserPosts(UserDto userDto);
	public PostDto updateUserPost(PostDto postDto);
	public void deleteUserPost(long id);
}
