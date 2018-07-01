package com.law.mapper;

import java.util.List;

import com.law.pojo.Options;

public interface OptionsMapper {
	
	List<Options> queryBySingleChoiceId(long singlechoiceId);
	
	List<Options> queryByMultipleChoiceId(long multiplechoieId);
	
	int insert(Options option);
	
	int update(Options option);
	
	int delete(long id);
}
