package com.law.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.law.dto.Result;
import com.law.pojo.Section;
import com.law.service.SectionService;

@Controller
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	SectionService sectionService;
	
	@RequestMapping(value = "/getByStudyId",method = RequestMethod.GET)
	@ResponseBody
	public Result<Section> getByStudyId(long studyId) {
		List<Section> sections = sectionService.getByStudyId(studyId);
		return new Result<>(true,sections);
	}
}
