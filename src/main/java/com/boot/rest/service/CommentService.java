package com.boot.rest.service;

import com.boot.rest.dto.CommentsDto;

public interface CommentService {

	public String addComments(CommentsDto commentsDto);

	void deleteComment(Long id);
}
