package com.law.mapper;

import java.util.List;

import com.law.pojo.Answer;

public interface AnswerMapper {

	List<Answer> queryBySingleChoiceId(long singlechoiceId);
	
	List<Answer> queryByMultipleChoiceId(long multiplechoiceId);
	
	int insert(Answer answer);
	
	int update(Answer answer);
	
	int delete(long id);
}
