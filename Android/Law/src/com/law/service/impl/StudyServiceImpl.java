package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.StudyMapper;
import com.law.pojo.Study;
import com.law.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService{

	@Autowired
	StudyMapper studyMapper;

	public List<Study> list(int offset, int limit) {
		return studyMapper.queryPaging(offset, limit);
	}
	
	public List<Study> list() {
		return studyMapper.queryAll();
	}


	@Override
	public boolean insertStudy(Study study) {
		int result = studyMapper.insertStudy(study);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteStudy(long id) {
		int result = studyMapper.deleteStudy(id);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateStudy(Study study) {
		int result = studyMapper.updateStudy(study);
		return (result > 0 ? true : false);
	}

	@Override
	public List<Study> getById(long id) {
		return studyMapper.queryById(id);
	}

	@Override
	public List<Study> getByClassify(String studyClassify) {
		return studyMapper.queryByClassify(studyClassify);
	}

}
