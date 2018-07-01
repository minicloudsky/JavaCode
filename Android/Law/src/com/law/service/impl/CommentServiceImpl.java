package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.CommentMapper;
import com.law.pojo.Comment;
import com.law.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public List<Comment> list() {
		return commentMapper.queryAll();
	}

	@Override
	public List<Comment> getById(long id) {
		return commentMapper.queryById(id);
	}

	@Override
	public boolean insert(Comment comment) {
		int result = commentMapper.insert(comment);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean update(Comment comment) {
		int result = commentMapper.update(comment);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean delete(long id) {
		int result = commentMapper.delete(id);
		return (result > 0 ? true : false);
	}

	@Override
	public List<Comment> getByTopicId(long topicId) {
		return commentMapper.queryByTopicId(topicId);
	}

}
