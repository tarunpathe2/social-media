package com.boot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.dto.CommentsDto;
import com.boot.rest.service.CommentService;
import com.boot.rest.util.Response;

@RestController
@RequestMapping("/social-media/")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	

	@PostMapping("comments")
	public Response<String> addComment(@RequestBody CommentsDto commentDto)
	{
		return new Response<String>(HttpStatus.OK.value(), commentService.addComments(commentDto));
	}

}
