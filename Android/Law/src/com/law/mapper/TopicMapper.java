package com.law.mapper;

import java.util.List;

import com.law.pojo.Topic;

public interface TopicMapper {

	List<Topic> queryAll();
	
	List<Topic> queryById(long id);
	
	List<Topic> queryByUserName(String username);
	
	int insert(Topic topic);
	
	int delete(long id);
	
	int update(Topic topic);
}
