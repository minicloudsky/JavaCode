package cn.edu.ayit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.ayit.antity.Visit;
import cn.edu.ayit.dao.VisitDao;
@Transactional
public class VisitService {
	private VisitDao visitDao;
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	/*添加数据到数据库*/
	public void add(Visit visit) {
		visitDao.add(visit);
	}
	/*列表*/
	public List<Visit> findAll() {
		return visitDao.findAll();
	}
	/*根据id查询*/
	public Visit findById(int vid) {
		return visitDao.findById(vid);
	}
	/*编辑*/
	public void edit(Visit visit) {
		visitDao.edit(visit);
	}
	
}
