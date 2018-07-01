package com.law.service;

import java.util.List;

import com.law.pojo.Options;

public interface OptionsService {

	
	List<Options> getBySingleChoiceId(long singlechoiceId);
	
	List<Options> getByMultipleChoiceId(long multiplechoieId);
	
	boolean insertOption(Options option);
	
	boolean updateOption(Options option);
	
	boolean deleteOption(long id);
}
