package com.boot.rest.service;

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
import com.boot.rest.dto.UserDto;
import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.model.Post;
import com.boot.rest.model.User;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepo;

	@Autowired
	private UserService userService;

	private Date date = new Date(Calendar.getInstance().getTime().getTime());

	public PostDto addPost(PostDto postDto, long id) {

		if (userRepository.existsById(id)) {
			Optional<User> user = userRepository.findById(id);
			postDto.setUser(user);
			postDto.setCreatedDate(date);
			postDto.setLike(0L);
			postDto.setUpdatedDate(date);
			Post post = modelMapper.map(postDto, Post.class);
			Post savedPost = postRepo.save(post);
			PostDto savedPostDto = modelMapper.map(savedPost, PostDto.class);
			return postDto;
		} else {
			throw new DataNotFoundException("User Profile Not Found");
		}

	}

	public List<PostDto> getAllPosts() {
		List<Post> post = postRepo.findAll();
		List<PostDto> postDto = post.stream().map(user -> modelMapper.map(user, PostDto.class))
				.collect(Collectors.toList());

		return postDto;
	}

	public String like(Long id) {
		if (postRepo.existsById(id)) {
			Optional<Post> op = postRepo.findById(id);
			op.get().setLike(op.get().getLike() + 1);
			postRepo.save(op.get());
			return "Thanks for Like";
		} else {
			throw new DataNotFoundException("PostNotFound");
		}
	}

	public List<PostDto> getPosts(long id) {
		if (userRepository.existsById(id)) {
			List<Post> postList = postRepo.findPostByUserOrderById(userRepository.findById(id));
			List<PostDto> postDtoList = new ArrayList<>();
			for (Post post : postList) {
				postDtoList.add(modelMapper.map(post, PostDto.class));
			}
			return postDtoList;
		} else {
			throw new DataNotFoundException("user profile not found");
		}
	}

	public Post updateUserPost(Long uId, Long pId, Post model) {
		if (userRepository.existsById(uId)) {
			if (postRepo.existsById(pId)) {
				Optional<Post> op = postRepo.findById(pId);
				op.get().setUpdatedDate(date);
				if (model.getPostName() != null)
					op.get().setPostName(model.getPostName());
				if (model.getDetails() != null)
					op.get().setDetails(model.getDetails());
				postRepo.save(op.get());
				return op.get();
			} else {
				throw new DataNotFoundException("post not found");
			}
		} else {
			throw new DataNotFoundException("user not found");
		}
	}

	public String deleteUserPost(Long uId, Long pId) {
		if (userRepository.existsById(uId)) {
			if (postRepo.existsById(pId)) {
				postRepo.deleteById(pId);
				return "post deleted successfully";
			} else {
				throw new DataNotFoundException("post not found");
			}
		} else {
			throw new DataNotFoundException("user not found");
		}
	}

}
