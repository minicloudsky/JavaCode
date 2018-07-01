package com.law.service;

import java.util.List;

import com.law.pojo.SingleChoice;

public interface SingleChoiceService {

	
	List<SingleChoice> getByExamId(long examId);
	
	boolean updateSingleChoice(SingleChoice singleChoice);
	
	boolean insertSingleChoice(SingleChoice singleChoice);
	
	boolean deleteSingleChoice(long id);
}
