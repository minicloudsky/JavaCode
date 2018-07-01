package com.law.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.law.mapper.StudyMapper;
import com.law.pojo.Study;


public class StudyTest extends BaseTest{

	@Autowired
	public StudyMapper studyMapper;
	
	@Test
	public void testQueryById() throws Exception{
		
	}
	@Test
	public void testQueryAll() throws Exception{
		
	}
	
	@Test
	public void testInsertStudy() throws Exception{
		String title = "中国法律";
		String classify = "宪法";
		Study study = new Study();
		study.setStudyTitle(title);
		study.setStudyClassify(classify);
		int pos = studyMapper.insertStudy(study);
		System.out.println("test:"+pos);
	}
	
	@Test
	public void testDeleteStudy() throws Exception{
		long id = 1;
		int pos = studyMapper.deleteStudy(id);
		System.out.println(pos);
	}
	@Test
	public void testUpdateStudy() throws Exception{
		
	}
}
