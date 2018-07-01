package com.law.service;

import java.util.List;

import com.law.pojo.MultipleChoice;

public interface MultipleChoiceService {

	
	List<MultipleChoice> getByExamId(long examId);
	
	boolean insertMultipleChoice(MultipleChoice multipleChoice);
	
	boolean updateMultipleChoice(MultipleChoice multipleChoice);
	
	boolean deleteMultipleChoice(long id);
}
