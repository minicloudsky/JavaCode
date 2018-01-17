package cn.edu.ayit.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.ayit.antity.Customer;

public class CustomerDao extends HibernateDaoSupport {
	
	/*
	 * 添加客户
	 * */
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}
	/*
	 * 客户列表
	 * */
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}
	/*删除客户*/
	public void delete(Customer c) {
		this.getHibernateTemplate().delete(c);	
	}
	/*根据cid进行查询*/
	public Customer findOne(int cid) {
		return this.getHibernateTemplate().get(Customer.class,cid);
	}
	/*保存客户*/
	public void keep(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}
	/*查询总记录数*/
	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if(list.size() != 0 && list != null) {
			Long lob = (Long) list.get(0);
			int count = lob.intValue();
			return count;
		}else {
			return 0;
		}
	}
	/*查询每页记录的list集合*/
	@SuppressWarnings("all")
	public List<Customer> findPage(int begin, int pageCount) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin,pageCount);
		return list;
	}
	/*条件查询*/
	@SuppressWarnings("all")
	public List<Customer> select(Customer customer) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(customer.getCustName() != null && !"".equals(customer.getCustName())){
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
		if(customer.getCustLevel() != null && !"".equals(customer.getCustLevel())) {
			criteria.add(Restrictions.eq("custLevel",customer.getCustLevel()));
		}
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	
	

}
