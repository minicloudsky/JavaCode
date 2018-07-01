package com.law.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.law.dto.Result;
import com.law.pojo.Topic;
import com.law.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	@ResponseBody
	public Result<Topic> getById(long id) {
		List<Topic> topics = topicService.getById(id);
		if(topics != null && topics.size() > 0) {
			return new Result<>(true,topics);
		}else {
			return new Result<>(false, "不存在该话题");
		}
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public Result<Topic> list() {
		List<Topic> topics = topicService.list();
		return new Result<>(true,topics);
	
	}
	
	@RequestMapping(value = "/getByUserName",method = RequestMethod.GET)
	@ResponseBody
	public Result<Topic> getByUserName(String username) {
		List<Topic> topics = topicService.getByUserName(username);
		return new Result<>(true,topics);
	
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public Result<Topic> insert(@RequestBody Topic topic) {
		boolean result = topicService.insertTopic(topic);
		return new Result<>(result,"");
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	@ResponseBody
	public Result<Topic> delete(long id) {
		boolean result = topicService.deleteTopic(id);
		return new Result<>(result,"");
	}
}
