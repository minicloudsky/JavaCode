package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.LawyerMapper;
import com.law.pojo.Lawyer;
import com.law.service.LawyerService;

@Service
public class LawyerServiceImpl implements LawyerService{

	@Autowired
	LawyerMapper lawyerMapper;
	
	public List<Lawyer> list() {
		return lawyerMapper.queryAll();
	}

	@Override
	public List<Lawyer> getByUserId(long userId) {
		return lawyerMapper.queryByUserId(userId);
	}

	@Override
	public boolean insertLawyer(Lawyer lawyer) {
		int result = lawyerMapper.insert(lawyer);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean updateLawyer(Lawyer lawyer) {
		int result = lawyerMapper.update(lawyer);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteLawyer(long id) {
		int result = lawyerMapper.delete(id);
		return (result > 0 ? true : false);
	}


}
