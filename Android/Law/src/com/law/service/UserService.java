package com.law.service;

import java.util.List;

import com.law.pojo.User;

public interface UserService {

	List<User> list();
	
	User getUserById(long id);
	
	User getUserByPhone(String phone);
	
	User getUserByName(String name);
	
	boolean updateUser(User user);
	
	boolean insertUser(User user);
	
}
