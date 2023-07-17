package com.skumar.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.skumar.exception.PostException;
import com.skumar.model.Posts;
import com.skumar.model.Users;
import com.skumar.repository.PostRepository;

@Service
public class PostService implements PostServiceDao{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Posts createPost(Posts post,Authentication auth) throws PostException {
		if(post==null) throw new PostException("Invalid data");
			post.setPostedDate(LocalDateTime.now());
			Users users= userService.getUserDetailByEmail(auth.getName());
			post.setUser(users);
			postRepository.save(post);
			return post;
	}

	@Override
	public List<Posts> viewPosts() throws PostException{
		List<Posts> posts = postRepository.findAll();
		if(posts.size()==0) throw new PostException("No post available");
		return posts;
	}

	@Override
	public Posts updatePost(Posts post, Integer id) throws PostException {
		Optional<Posts> opt = postRepository.findById(id);
		if(opt.isEmpty()) throw new PostException("Invalid id");
		Posts getPost = opt.get();
		getPost.setContent(post.getContent());
		getPost.setTitle(post.getTitle());
		return getPost;
	}

	@Override
	public Posts deletePost(Integer id) throws PostException {
		Optional<Posts> post = postRepository.findById(id);
		if(post.isEmpty()) throw new PostException("Id is not available");
		Posts p = post.get();
		postRepository.deleteById(id);
		return p;
	}

}
