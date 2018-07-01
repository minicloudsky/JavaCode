package com.law.service;

import java.util.List;

import com.law.pojo.Answer;

public interface AnswerService {

	List<Answer> getBySingleChoiceId(long singlechoiceId);
	
	List<Answer> getByMultipleChoiceId(long multiplechoiceId);
	
	boolean insertAnswer(Answer answer);
	
	boolean updateAnswer(Answer answer);
	
	boolean deleteAnswer(long id);
}
