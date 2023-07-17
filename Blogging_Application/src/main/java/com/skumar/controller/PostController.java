package com.skumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skumar.model.Posts;
import com.skumar.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public ResponseEntity<Posts> createNewPostHandler(@RequestBody Posts post,Authentication auth){
		Posts newPost = postService.createPost(post, auth);
		return new ResponseEntity<>(newPost,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<Posts>> getAllPostsHandler(){
		List<Posts> posts = postService.viewPosts();
		return new ResponseEntity<>(posts,HttpStatus.ACCEPTED);
	}
	
	
	@PatchMapping("/post/{id}")
	public ResponseEntity<Posts> updatePostsHandler(@RequestBody Posts post,@PathVariable Integer id){
		Posts posts = postService.updatePost(post,id);
		return new ResponseEntity<>(posts,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<Posts> deletePostsHandler(@PathVariable Integer id){
		Posts posts = postService.deletePost(id);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	
	
}
