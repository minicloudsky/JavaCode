package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.SingleChoiceMapper;
import com.law.pojo.SingleChoice;
import com.law.service.SingleChoiceService;

@Service
public class SingleChoiceServiceImpl implements SingleChoiceService{

	@Autowired
	SingleChoiceMapper singlechoiceMapper;
	
	@Override
	public List<SingleChoice> getByExamId(long examId) {
		return singlechoiceMapper.queryByExamId(examId);
	}

	@Override
	public boolean updateSingleChoice(SingleChoice singleChoice) {
		int result = singlechoiceMapper.update(singleChoice);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean insertSingleChoice(SingleChoice singleChoice) {
		int result = singlechoiceMapper.insert(singleChoice);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteSingleChoice(long id) {
		int result = singlechoiceMapper.delete(id);
		return (result > 0 ? true : false);
	}

}
