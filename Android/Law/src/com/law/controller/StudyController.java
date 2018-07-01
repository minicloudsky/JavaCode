package com.law.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.law.dto.Result;
import com.law.pojo.Study;
import com.law.service.StudyService;

@Controller
@RequestMapping("/study")
public class StudyController {

	@Autowired
	StudyService studyService;
	
/*	@RequestMapping("listStudy")
	public ModelAndView listStudent(int offset,int limit) {
		ModelAndView  mav = new ModelAndView();
		List<Study> studies = studyService.list(offset, limit);
		mav.addObject("studies", studies);
		mav.setViewName("listStudy");
		return mav;
	}
	*/
	
	@RequestMapping(value="listStudy",method=RequestMethod.GET)
	public ModelAndView listStudy() {
		ModelAndView  mav = new ModelAndView();
		mav.setViewName("listStudy");
		return mav;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	private List<Study> list() {
		List<Study> studies = studyService.list();
		return studies;
	}
	
	@RequestMapping(value = "/getByClassify",method = RequestMethod.GET)
	@ResponseBody
	private Result<Study> getByClassify(String studyClassify) {
		List<Study> studies = studyService.getByClassify(studyClassify);
		if(studies != null && studies.size() > 0) {
			return new Result(true,studies);
		}else {
			return new Result<>(true,"");
		}
	}
}

