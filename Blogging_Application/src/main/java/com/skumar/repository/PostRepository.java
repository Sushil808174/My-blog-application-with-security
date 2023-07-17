package com.skumar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skumar.model.Posts;

public interface PostRepository extends JpaRepository<Posts, Integer>{

//	Optional<Posts> findById(Integer id);
}
