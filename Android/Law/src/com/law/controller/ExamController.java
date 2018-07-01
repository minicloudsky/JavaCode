package com.law.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.law.dto.ExamResult;
import com.law.dto.Result;
import com.law.pojo.Answer;
import com.law.pojo.Exam;
import com.law.pojo.MultipleChoice;
import com.law.pojo.Options;
import com.law.pojo.SingleChoice;
import com.law.service.AnswerService;
import com.law.service.ExamService;
import com.law.service.MultipleChoiceService;
import com.law.service.OptionsService;
import com.law.service.SingleChoiceService;
import com.law.service.impl.AnswerServiceImpl;
import com.law.service.impl.MultipleChoiceSeriveImpl;
import com.law.service.impl.OptionsServiceImpl;
import com.law.service.impl.SingleChoiceServiceImpl;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamService examService;
	@Autowired
	SingleChoiceService singleChoiceService;
	@Autowired
	MultipleChoiceService multipleChoiceService;
	@Autowired
	OptionsService optionService;
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	@ResponseBody
	public Result<Exam> getById(long id) {
		List<Exam> exams = examService.getById(id);
		if(exams != null && exams.size() > 0) {
			return new Result<>(true,exams);
		}else {
			return new Result<>(false, "");
		}
	}
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public Result<Exam> getById() {
		List<Exam> exams = examService.list();
		if(exams != null && exams.size() > 0) {
			return new Result<>(true,exams);
		}else {
			return new Result<>(false, "");
		}
	}
	@RequestMapping(value = "/getByClassify",method = RequestMethod.GET)
	@ResponseBody
	public Result<Exam> getById(String classify) {
		List<Exam> exams = examService.getByClassify(classify);
		if(exams != null && exams.size() > 0) {
			System.out.println(exams.get(0).toString());
			return new Result<>(true,exams);
		}else {
			return new Result<>(false, "");
		}
	}
	
	@RequestMapping(value = "/getContent",method = RequestMethod.GET)
	@ResponseBody
	public Result<ExamResult> getContent(long examId) {
		System.out.println(examId);
		Exam exam = examService.getById(examId).get(0);
		List<ExamResult> examResults = new ArrayList<>();
		ExamResult examResult = new ExamResult();
		examResult.setExamId(examId);
		examResult.setExam(exam);
		List<MultipleChoice> multipleChoices = multipleChoiceService.getByExamId(examId);
		for(int i=0;i<multipleChoices.size();i++) {
			MultipleChoice multipleChoice = multipleChoices.get(i);
			List<Options> options = optionService.getByMultipleChoiceId(multipleChoice.getId());
			multipleChoice.setOptions(options);
			List<Answer> answers = answerService.getByMultipleChoiceId(multipleChoice.getId());
			multipleChoice.setAnswer(answers);
		}
		List<SingleChoice> singleChoices =singleChoiceService.getByExamId(examId);
		for(int j=0;j<singleChoices.size();j++) {
			SingleChoice singleChoice = singleChoices.get(j);
			List<Options> options = optionService.getBySingleChoiceId(singleChoice.getId());
			singleChoice.setOptions(options);
			List<Answer> answers = answerService.getBySingleChoiceId(singleChoice.getId());
			singleChoice.setAnswer(answers.get(0));
		}
		examResult.setMultipleChoices(multipleChoices);
		examResult.setSingleChoices(singleChoices);
		examResults.add(examResult);
		return new Result<>(true,examResults);
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public Result<Exam> insert(@RequestBody Exam exam) {
		boolean result = examService.insertExam(exam);
		return new Result<>(result,"");
	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public Result<Exam> update(@RequestBody Exam exam) {
		boolean result = examService.updateExam(exam);
		return new Result<>(result,"");
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	@ResponseBody
	public Result<Exam> insert(long id) {
		boolean result = examService.deleteExam(id);
		return new Result<>(result,"");
	}
}

