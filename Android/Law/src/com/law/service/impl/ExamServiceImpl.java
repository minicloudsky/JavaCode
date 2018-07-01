package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.ExamMapper;
import com.law.pojo.Exam;
import com.law.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamMapper examMapper;
	
	@Override
	public List<Exam> list() {
		return examMapper.queryAll();
	}

	@Override
	public List<Exam> getById(long id) {
		return examMapper.queryById(id);
	}

	@Override
	public List<Exam> getByClassify(String classify) {
		return examMapper.queryByClassify(classify);
	}

	@Override
	public boolean insertExam(Exam exam) {
		int result = examMapper.insert(exam);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateExam(Exam exam) {
		int result = examMapper.update(exam);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteExam(long id) {
		int result = examMapper.deleteById(id);
		return (result > 0 ? true : false);
	}

}
