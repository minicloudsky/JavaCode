package com.law.mapper;

import java.util.List;

import com.law.pojo.Lawyer;

public interface LawyerMapper {

	List<Lawyer> queryAll();
	
	List<Lawyer> queryByUserId(long userId);
	
	int insert(Lawyer lawyer);
	
	int update(Lawyer lawyer);
	
	int delete(long id);
}
