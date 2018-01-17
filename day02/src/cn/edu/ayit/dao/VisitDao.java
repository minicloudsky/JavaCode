package cn.edu.ayit.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.ayit.antity.Visit;

public class VisitDao extends HibernateDaoSupport{
	/*添加数据*/
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}
	/*列表*/
	@SuppressWarnings("all")
	public List<Visit> findAll() {
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");		
	}
	/*根据id查询*/
	public Visit findById(int vid) {
		return  this.getHibernateTemplate().get(Visit.class, vid);
	}
	/*编辑*/
	public void edit(Visit visit) {
		this.getHibernateTemplate().update(visit);
	}
	
}
