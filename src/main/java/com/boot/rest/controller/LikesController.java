package com.boot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.dto.LikesDto;
import com.boot.rest.service.LikesService;
import com.boot.rest.util.Response;

@RestController
@RequestMapping("/social-media/")
public class LikesController {
	
	@Autowired
	private LikesService likeService;
	
	@PostMapping("post/like")
	public Response<String> setLike(@RequestBody LikesDto likesDto)
	{
		return new Response<String>(HttpStatus.OK.value(), likeService.postLike(likesDto));
	}

}
