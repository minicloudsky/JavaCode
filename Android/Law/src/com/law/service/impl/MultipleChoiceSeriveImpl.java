package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.MultipleChoiceMapper;
import com.law.pojo.MultipleChoice;
import com.law.service.MultipleChoiceService;

@Service
public class MultipleChoiceSeriveImpl implements MultipleChoiceService{

	@Autowired
	MultipleChoiceMapper multiplechoiceMapper;
	
	@Override
	public List<MultipleChoice> getByExamId(long examId) {
		System.out.println("examId" + examId + multiplechoiceMapper);
		List<MultipleChoice> multipleChoices = multiplechoiceMapper.queryByExamId(examId);
		return multipleChoices;
	}

	@Override
	public boolean insertMultipleChoice(MultipleChoice multipleChoice) {
		int result = multiplechoiceMapper.insert(multipleChoice);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateMultipleChoice(MultipleChoice multipleChoice) {
		int result = multiplechoiceMapper.update(multipleChoice);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteMultipleChoice(long id) {
		int result = multiplechoiceMapper.delete(id);
		return (result > 0 ? true : false);
	}

}
