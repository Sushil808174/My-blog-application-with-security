package com.skumar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skumar.exception.UserException;
import com.skumar.model.Users;
import com.skumar.repository.UserRepository;

@Service
public class UserService implements UserServiceDao{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users registerUsers(Users user) throws UserException {
		if(user==null) throw new UserException("Invalid data");
		Optional<Users> opt =userRepository.findByEmail(user.getEmail());
		if(opt.isEmpty()) {
			userRepository.save(user);
			return user;
		}else {
			throw new UserException("User account is already created");
		}
		
	}
	
	public Users getUserDetailByEmail(String email) throws UserException{
		return userRepository.findByEmail(email).orElseThrow(()->new UserException("User not found with given email : "+email));
	}

	public List<Users> getAllUser() {
		List<Users> users = userRepository.findAll();
		return users;
	}
	
	

}
