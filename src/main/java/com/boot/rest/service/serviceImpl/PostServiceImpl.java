package com.boot.rest.service.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.dto.PostDto;
import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.model.Post;
import com.boot.rest.model.Tags;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	private void postExist(long id) {
		if (!postRepository.existsById(id)) {
			throw new DataNotFoundException("Post Not Found");
		}
	}

	private void userExist(long id) {
		if (!userRepository.existsById(id)) {
			throw new DataNotFoundException("User Not Found");
		}
	}

	private Date date = new Date(Calendar.getInstance().getTime().getTime());

	public PostDto addPost(PostDto postDto) {

		userExist(postDto.getUserId());
		Post post = modelMapper.map(postDto, Post.class);
		post.setUser(userRepository.findById(postDto.getUserId()).get());
		post.setCreatedDate(date);
		post.setUpdatedDate(date);
		List<Tags> tags = new ArrayList<>();
		postDto.getTags().stream().forEach(e -> {
			Tags tag = new Tags();
			tag.setName(e.getName());
			tag.setPost(post);
			tags.add(tag);
		});
		post.setTags(tags);
		postRepository.save(post);
		return modelMapper.map(post, PostDto.class);

	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> post = postRepository.findAll();
		List<PostDto> postDto = post.stream().map(user -> modelMapper.map(user, PostDto.class))
				.collect(Collectors.toList());

		return postDto;
	}
	
	@Override
	public PostDto getPost(long id) {
		postExist(id);
		return modelMapper.map(postRepository.findById(id).get(), PostDto.class);
	}

	@Override
	public PostDto updateUserPost(PostDto postDto) {
		postExist(postDto.getId());
		Optional<Post> optionalPost = postRepository.findById(postDto.getId());
		Post post = optionalPost.get();
		post.setUpdatedDate(date);
		post.setPostName(postDto.getPostName());
		post.setDetails(postDto.getDetails());
		List<Tags> tags = new ArrayList<>();
		postDto.getTags().stream().forEach(e -> {
			Tags tag = new Tags();
			tag.setName(e.getName());
			tag.setPost(post);
			tags.add(tag);
		});
		post.setTags(tags);
		postRepository.save(post);
		return modelMapper.map(post, PostDto.class);

	}

	@Override
	public void deleteUserPost(long id) {
		postRepository.deleteById(id);
	}

}
