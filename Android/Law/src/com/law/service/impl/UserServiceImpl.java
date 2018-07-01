package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.UserMapper;
import com.law.pojo.User;
import com.law.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	public List<User> list() {
		return userMapper.queryAll();
	}

	public User getUserById(long id) {
		List<User> users = userMapper.queryById(id);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	public boolean updateUser(User user) {
		int result = userMapper.update(user);
		System.out.println(result);
		return (result > 0 ? true : false);
	}

	public User getUserByPhone(String phone) {
		List<User> users = userMapper.queryByPhone(phone);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	public User getUserByName(String name) {
		List<User> users = userMapper.queryByName(name);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	public boolean insertUser(User user) {
		int result = userMapper.insert(user);
		return (result > 0 ? true : false);
	}
	
}

