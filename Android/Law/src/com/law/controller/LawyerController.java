package com.law.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.law.dto.Result;
import com.law.pojo.Lawyer;
import com.law.pojo.Section;
import com.law.service.LawyerService;

@Controller
@RequestMapping("/lawyer")
public class LawyerController {
	
	@Autowired
	LawyerService lawyerService;
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public Result<Lawyer> insert(@RequestBody Lawyer lawyer) {
		System.out.println(lawyer.toString());
		boolean result = lawyerService.insertLawyer(lawyer);
		return new Result<>(result,"");
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public Result<Lawyer> list() {
		List<Lawyer> lawyers = lawyerService.list();
		return new Result<>(true,lawyers);
	}
	@RequestMapping(value = "/getByUserId",method = RequestMethod.GET)
	@ResponseBody
	public Result<Lawyer> getByUserId(long userId) {
		List<Lawyer> lawyers = lawyerService.getByUserId(userId);
		return new Result<>(true,lawyers);
	}
}
