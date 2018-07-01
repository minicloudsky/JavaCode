package com.law.service;

import java.util.List;

import com.law.pojo.Exam;

public interface ExamService {

	List<Exam> list();
	
	List<Exam> getById(long id);
	
	List<Exam> getByClassify(String classify);
	
	boolean insertExam(Exam exam);
	
	boolean updateExam(Exam exam);
	
	boolean deleteExam(long id);
}
