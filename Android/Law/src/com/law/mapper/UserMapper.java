package com.law.mapper;

import java.util.List;
import com.law.pojo.User;

public interface UserMapper {

	List<User> queryAll();
	
	List<User> queryById(long id);
	
	List<User> queryByPhone(String userPhone);
	
	List<User> queryByName(String userName);
	
	int insert(User user);
	
	int update(User user);
	
	int delete(long id);
}
