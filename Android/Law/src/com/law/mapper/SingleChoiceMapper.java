package com.law.mapper;

import java.util.List;

import com.law.pojo.SingleChoice;

public interface SingleChoiceMapper {

	List<SingleChoice> queryByExamId(long examId);
	
	int update(SingleChoice singleChoice);
	
	int insert(SingleChoice singleChoice);
	
	int delete(long id);
	
}
