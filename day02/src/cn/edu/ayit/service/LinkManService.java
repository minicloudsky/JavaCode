package cn.edu.ayit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.ayit.antity.LinkMan;
import cn.edu.ayit.dao.LinkManDao;
@Transactional
public class LinkManService {
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	/*添加联系人*/
	public void add(LinkMan linkMan) {
		linkManDao.add(linkMan);
	}
	/*联系人列表*/
	public List<LinkMan> listLinkMan() {
		return linkManDao.listLinkMan();
	}
	/*根据id查询*/
	public LinkMan findById(int id) {
		return linkManDao.findById(id);
	}
	/*修改联系人*/
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	/*条件查询*/
	public List<LinkMan> select(LinkMan linkMan) {
		return linkManDao.select(linkMan);
	}
	
	
	
	
		
	
	
	
}
