package com.skumar.service;

import org.springframework.security.core.Authentication;

import com.skumar.exception.CommentException;
import com.skumar.model.Comments;

public interface CommentServiceDao {

	public Comments doComment(Authentication auth,Integer postId,Comments comment) throws CommentException;
}
