package com.law.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.mapper.SectionMapper;
import com.law.pojo.Section;
import com.law.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{

	@Autowired
	SectionMapper sectionMapper;
	
	@Override
	public List<Section> getByStudyId(long studyId) {
		return sectionMapper.queryByStudyId(studyId);
	}

	@Override
	public boolean insert(Section section) {
		int result = sectionMapper.insert(section);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean update(Section section) {
		int result = sectionMapper.update(section);
		return (result > 0 ? true : false);
	}

	@Override
	public boolean deleteById(long id) {
		int result = sectionMapper.deleteById(id);
		return (result > 0 ? true : false);
	}

}
