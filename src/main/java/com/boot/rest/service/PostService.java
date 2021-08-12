package com.boot.rest.service;

import java.util.List;

import com.boot.rest.dto.PostDto;
import com.boot.rest.model.Post;

public interface PostService {

	public PostDto addPost(PostDto postDto, long id);
	public List<PostDto> getAllPosts();
	public String like(Long id);
	public List<PostDto> getPosts(long id);
	public Post updateUserPost(Long uId, Long pId, Post model);
	public String deleteUserPost(Long uId, Long pId);
}
