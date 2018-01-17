package cn.edu.ayit.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.ayit.antity.LinkMan;

public class LinkManDao extends HibernateDaoSupport{
	/*添加联系人*/
	public void add(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}
	/*联系人列表*/
	@SuppressWarnings("all")
	public List<LinkMan> listLinkMan() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}
	/*根据id查询*/
	public LinkMan findById(int id) {
		return this.getHibernateTemplate().get(LinkMan.class, id);
	}
	/*修改联系人*/
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}
	/*条件查询*/
	@SuppressWarnings("all")
	public List<LinkMan> select(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid()>0) {
			criteria.add(Restrictions.eq("customer.cid",linkMan.getCustomer().getCid()));
		}
		if(linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
			criteria.add(Restrictions.eq("lkmName",linkMan.getLkmName()));
		}
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
}
