package com.law.mapper;


import java.util.List;


import com.law.pojo.Study;


public interface StudyMapper {

	
	
	public List<Study> queryById(long id);

	public List<Study> queryPaging(int offset,int limit);
	
	public List<Study> queryAll();
	
	List<Study> queryByClassify(String studyClassify);
	
	public int insertStudy(Study study);
	
	public int deleteStudy(long id);
	
	public int updateStudy(Study study);
	
}