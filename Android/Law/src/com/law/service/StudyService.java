package com.law.service;

import java.util.List;

import com.law.pojo.Study;

public interface StudyService {

	List<Study> list(int offset,int limit);
	
	List<Study> list();
	
	 List<Study> getById(long id);
	 
	 List<Study> getByClassify(String studyClassify);

	 boolean insertStudy(Study study);
	
	 boolean deleteStudy(long id);
	
	 boolean updateStudy(Study study);
}
