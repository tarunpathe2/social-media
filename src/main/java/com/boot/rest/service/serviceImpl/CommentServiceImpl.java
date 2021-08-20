package com.boot.rest.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.dto.CommentsDto;
import com.boot.rest.exception.DataNotFoundException;
import com.boot.rest.model.Comments;
import com.boot.rest.repository.CommentRepository;
import com.boot.rest.repository.PostRepository;
import com.boot.rest.repository.UserRepository;
import com.boot.rest.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public String addComments(CommentsDto commentsDto) {
		if (!postRepo.existsById(commentsDto.getPostId())) {
			throw new DataNotFoundException("Post does not exist");
		}
		Comments comment = modelMapper.map(commentsDto, Comments.class);
		comment.setPost(postRepo.findById(commentsDto.getPostId()).get());
		comment = commentRepo.save(comment);
		return "Comment Saved";
		
	}
	
	@Override
	public void deleteComment(Long id)
	{
		commentRepo.deleteById(id);
	}
}
