package com.law.service;

import java.util.List;

import com.law.pojo.Comment;

public interface CommentService {

	List<Comment> list();
	
	List<Comment> getById(long id);
	
	List<Comment> getByTopicId(long topicId);
	
	boolean insert(Comment comment);
	
	boolean update(Comment comment);
	
	boolean delete(long id);
}
