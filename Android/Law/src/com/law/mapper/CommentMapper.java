package com.law.mapper;

import java.util.List;

import com.law.pojo.Comment;

public interface CommentMapper {

	List<Comment> queryAll();
	
	List<Comment> queryById(long id);
	
	List<Comment> queryByTopicId(long topicId);
	
	int insert(Comment comment);
	
	int update(Comment comment);
	
	int delete(long id);
	
}
