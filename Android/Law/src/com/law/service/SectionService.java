package com.law.service;

import java.util.List;

import com.law.pojo.Section;

public interface SectionService {


	List<Section> getByStudyId(long studyId);

	boolean insert(Section section);
	
	
	boolean update(Section section);
	
	
	boolean deleteById(long id);
}
