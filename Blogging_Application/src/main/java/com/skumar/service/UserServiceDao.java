package com.skumar.service;

import com.skumar.exception.UserException;
import com.skumar.model.Users;

public interface UserServiceDao {

	public Users registerUsers(Users user) throws UserException;
}
