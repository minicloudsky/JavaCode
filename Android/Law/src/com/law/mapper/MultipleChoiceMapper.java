package com.law.mapper;

import java.util.List;

import com.law.pojo.MultipleChoice;

public interface MultipleChoiceMapper {

	List<MultipleChoice> queryByExamId(long examId);
	
	int insert(MultipleChoice multipleChoice);
	
	int update(MultipleChoice multipleChoice);
	
	int delete(long id);
}
