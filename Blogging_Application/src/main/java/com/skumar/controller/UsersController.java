package com.skumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skumar.model.Users;
import com.skumar.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/hello")
	public ResponseEntity<String> helloHandler(){
		return new ResponseEntity<>("Welcome to the blog application",HttpStatus.OK);
	}
	@GetMapping("/secure")
	public ResponseEntity<String> checkSecurityHandler(){
		return new ResponseEntity<>("Welcome to the blog application with security",HttpStatus.OK);
	}
	
	/*
	{
		  "userName": "himanshu",
		  "email":"himanshu@gmail.com",
		  "password":"1234",
		  "role" : "user"
		}
	*/
	
	@PostMapping("/user")
	public ResponseEntity<Users> registerUserHandler(@RequestBody Users user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_"+user.getRole().toUpperCase());
		Users registerUser = userService.registerUsers(user);
		return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> viewAllUsersHandler(){
		List<Users> allUser = userService.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/signIn")
    public ResponseEntity<Users> getLoggedInCustomerDetailsHandler(Authentication auth){


        Users users= userService.getUserDetailByEmail(auth.getName());

        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
	
	
	
}
