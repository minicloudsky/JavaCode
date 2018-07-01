package com.law.service;

import java.util.List;

import com.law.pojo.Lawyer;

public interface LawyerService {

	

	List<Lawyer> list();

	List<Lawyer> getByUserId(long userId);
	
	boolean insertLawyer(Lawyer lawyer);
	
	boolean updateLawyer(Lawyer lawyer);
	
	boolean deleteLawyer(long id);
}
