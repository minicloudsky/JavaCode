package com.law.mapper;

import java.util.List;

import com.law.pojo.Section;

public interface SectionMapper {

	/**
	 * 根据学习资料id查询章节
	 * @param id
	 * @return
	 */
	List<Section> queryByStudyId(long studyId);
	
	int insert(Section section);
	
	/**
	 * 根据章节id更新章节
	 * @param id
	 * @return
	 */
	int update(Section section);
	
	/**
	 * 根据章节id删除章节
	 * @param id
	 * @return
	 */
	int deleteById(long id);
}
