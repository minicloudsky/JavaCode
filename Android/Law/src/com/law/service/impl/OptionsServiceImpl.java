package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.OptionsMapper;
import com.law.pojo.Options;
import com.law.service.OptionsService;

@Service
public class OptionsServiceImpl implements OptionsService{

	@Autowired
	OptionsMapper optionsMapper;
	
	@Override
	public List<Options> getBySingleChoiceId(long singlechoiceId) {
		return optionsMapper.queryBySingleChoiceId(singlechoiceId);
	}

	@Override
	public List<Options> getByMultipleChoiceId(long multiplechoieId) {
		return optionsMapper.queryByMultipleChoiceId(multiplechoieId);
	}

	@Override
	public boolean insertOption(Options option) {
		int result = optionsMapper.insert(option);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateOption(Options option) {
		int result = optionsMapper.update(option);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteOption(long id) {
		int result = optionsMapper.delete(id);
		return (result > 0 ? true : false);
	}

}
