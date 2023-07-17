package com.skumar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skumar.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByEmail(String email);
}
