package com.skumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skumar.model.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
