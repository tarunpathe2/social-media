package com.boot.rest.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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

	private Date date = new Date(Calendar.getInstance().getTime().getTime());

	
	public PostDto addPost(UserDto userDto,long id) {

		Post post = new Post();
		Optional<User> user = userRepository.findByEmail(userDto.getEmail());
		post.setUser(user);
			return post;
		
			throw new DataNotFoundException("User Profile Not Found");

	}

	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

	public String like(Long id) {
		if (postRepo.existsById(id)) {
			Optional<Post> op = postRepo.findById(id);
			op.get().setLike(op.get().getLike() + 1);
			postRepo.save(op.get());
			return "Thanks for Like";
		} 
		else {
			throw new DataNotFoundException("PostNotFound");
		}
	}

	public List<Post> getPosts(Long id) {
		if (userRepository.existsById(id)) {
			Optional<User> op = userRepository.findById(id);
			return postRepo.findByUser(op.get());
		} else {
			throw new DataNotFoundException("user profile not found");
		}
	}

	public Post updateUserPost(Long uId, Long pId, Post model) {
		if (userRepository.existsById(uId)) {
			if (postRepo.existsById(pId)) {
				Optional<Post> op = postRepo.findById(pId);
				op.get().setUpdatedDate(date);
				if(model.getPostName() != null)
					op.get().setPostName(model.getPostName());
				if(model.getDetails() != null)
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
			throw new DataNotFoundException("user profile not found");
		}
	}

	
}
