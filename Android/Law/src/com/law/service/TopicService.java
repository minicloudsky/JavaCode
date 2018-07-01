package com.law.service;

import java.util.List;

import com.law.pojo.Topic;

public interface TopicService {

	
	List<Topic> list();
	
	List<Topic> getById(long id);
	
	List<Topic> getByUserName(String username);
	
	boolean insertTopic(Topic topic);
	
	boolean deleteTopic(long id);
	
	boolean updateTopic(Topic topic);
}
