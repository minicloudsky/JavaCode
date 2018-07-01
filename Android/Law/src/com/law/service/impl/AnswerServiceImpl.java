package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.AnswerMapper;
import com.law.pojo.Answer;
import com.law.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerMapper answerMapper;

	@Override
	public List<Answer> getBySingleChoiceId(long singlechoiceId) {
		return answerMapper.queryBySingleChoiceId(singlechoiceId);
	}

	@Override
	public List<Answer> getByMultipleChoiceId(long multiplechoiceId) {
		// TODO Auto-generated method stub
		return answerMapper.queryByMultipleChoiceId(multiplechoiceId);
	}

	@Override
	public boolean insertAnswer(Answer answer) {
		int result = answerMapper.insert(answer);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateAnswer(Answer answer) {
		int result = answerMapper.update(answer);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteAnswer(long id) {
		int result = answerMapper.delete(id);
		return (result > 0 ? true : false);
	}

	

}
