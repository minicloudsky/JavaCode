package com.law.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.law.dto.Result;
import com.law.pojo.Comment;
import com.law.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	@ResponseBody
	public Result<Comment> getById(long id) {
		List<Comment> topics = commentService.getById(id);
		if(topics != null && topics.size() > 0) {
			return new Result<>(true,topics);
		}else {
			return new Result<>(false, "不存在该话题");
		}
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public Result<Comment> list() {
		List<Comment> topics = commentService.list();
		if(topics != null) {
			return new Result<>(true,topics);
		}else {
			return new Result<>(false, "不存在该评论");
		}
	}
	
	
	@RequestMapping(value = "/getByTopicId",method = RequestMethod.GET)
	@ResponseBody
	public Result<Comment> getByTopicId(long topicId) {
		System.out.println(topicId);
		List<Comment> topics = commentService.getByTopicId(topicId);
		if(topics != null && topics.size() > 0) {
			return new Result<>(true,topics);
		}else {
			return new Result<>(false, "不存在该话题");
		}
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public Result<Comment> insert(@RequestBody Comment topic) {
		boolean result = commentService.insert(topic);
		return new Result<>(result,"");
	}
}
