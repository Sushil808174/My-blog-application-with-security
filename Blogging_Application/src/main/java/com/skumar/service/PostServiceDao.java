package com.skumar.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.skumar.exception.PostException;
import com.skumar.model.Posts;

public interface PostServiceDao {

	public Posts createPost(Posts post,Authentication auth) throws PostException;
	public List<Posts> viewPosts()throws PostException;
	public Posts updatePost(Posts post,Integer id) throws PostException;
	public Posts deletePost(Integer id) throws PostException;
}
