package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.TopicMapper;
import com.law.pojo.Topic;
import com.law.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	TopicMapper topicmapper;
	
	@Override
	public List<Topic> list() {
		return topicmapper.queryAll();
	}

	@Override
	public List<Topic> getById(long id) {
		return topicmapper.queryById(id);
	}

	@Override
	public boolean insertTopic(Topic topic) {
		int result = topicmapper.insert(topic);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteTopic(long id) {
		int result = topicmapper.delete(id);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateTopic(Topic topic) {
		int result = topicmapper.update(topic);
		return (result > 0 ? true : false);
	}

	@Override
	public List<Topic> getByUserName(String username) {
		return topicmapper.queryByUserName(username);
	}

}
