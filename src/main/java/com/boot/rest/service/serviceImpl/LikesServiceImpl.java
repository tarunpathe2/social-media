package com.boot.rest.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.dto.LikesDto;
import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.model.Likes;
import com.boot.rest.model.Post;
import com.boot.rest.repository.LikeRepository;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.service.LikesService;

@Service
public class LikesServiceImpl implements LikesService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private LikeRepository likeRepo;
	
	
	private void ifUserExist(Long id) {
		if (!userRepo.existsById(userRepo.findById(id).get().getId())) {
			throw new DataNotFoundException("");
		}
	}

	private void ifPostExist(Long id) {
		if (!postRepo.existsById(id)) {
			throw new DataNotFoundException("");
		}
	}
	
	@Override
	public String postLike(LikesDto likesDto)
	{
		ifUserExist(likesDto.getUserId());
		ifPostExist(likesDto.getPostId());
		Likes likes = modelMapper.map(likesDto, Likes.class);
		likeRepo.save(likes);
		Post post = postRepo.findById(likesDto.getPostId()).get();
		post.setTotalLikes(likeRepo.countByPostId(likesDto.getPostId()));
		postRepo.save(post);	
		return "Like successfully";
	}
	
}
