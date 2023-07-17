package com.skumar.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.skumar.exception.CommentException;
import com.skumar.model.Comments;
import com.skumar.model.Posts;
import com.skumar.model.Users;
import com.skumar.repository.CommentRepository;
import com.skumar.repository.PostRepository;

@Service
public class CommentService implements CommentServiceDao{

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Comments doComment(Authentication auth, Integer postId,Comments comment) throws CommentException {
		Optional<Posts> opt = postRepository.findById(postId);
		Posts post = opt.get();
		Users user = userService.getUserDetailByEmail(auth.getName());
		comment.setCreatedAt(LocalDateTime.now());
		comment.setPost(post);
		comment.setUser(user);
		commentRepository.save(comment);
		return comment;
	}

}
