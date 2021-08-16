package com.boot.rest.service;

import com.boot.rest.dto.CommentsDto;
import com.boot.rest.model.Comments;

public interface CommentService {

	public Comments addComments(CommentsDto commentsDto);
}
