package com.law.mapper;

import java.util.List;

import com.law.pojo.Exam;

public interface ExamMapper {

	List<Exam> queryById(long id);

	List<Exam> queryAll();
	
	List<Exam> queryByClassify(String classify);
	
	int insert(Exam exam);
	
	int update(Exam exam);
	
	int deleteById(long id);
}
