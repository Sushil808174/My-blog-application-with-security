package com.skumar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skumar.model.Comments;
import com.skumar.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	public ResponseEntity<Comments> commentsHandler(Authentication auth,Integer postId,@RequestBody Comments comment){
		Comments commentsCreated = commentService.doComment(auth, postId, comment);
		return new ResponseEntity<>(commentsCreated,HttpStatus.CREATED);
	}
}
