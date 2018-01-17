package cn.edu.ayit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ModelDriven;

import cn.edu.ayit.antity.Customer;
import cn.edu.ayit.antity.PageBean;
import cn.edu.ayit.dao.CustomerDao;
@Transactional
public class CustomerService{
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	/*添加客户*/
	public void add(Customer customer) {
		
		customerDao.add(customer);
	}
	/*
	 * 客户列表
	 * */
	public List<Customer> findAll() {
		return customerDao.findAll();
		
	}
	/*根据cid进行查询*/
	public Customer findOne(int cid) {
		return customerDao.findOne(cid);
	}
	/*删除客户*/
	public void delete(Customer c) {
		customerDao.delete(c);
		
	}
	/*编辑客户*/
	public void keep(Customer customer) {
		customerDao.keep(customer);
		
	}
	/*封装分页数据*/
	public PageBean listPage(Integer currentPage) {
		//封装当前页数据
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		//封装总记录数
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装每页记录数
		int pageCount = 3;
		
		//封装总页数
		int totalPage = 0;
		if(totalCount%pageCount == 0) { //整除
			 totalPage = totalCount/pageCount;
		}else {	//不能整除
			 totalPage = totalCount/pageCount+1;
		}
		pageBean.setTotalPage(totalPage);
		//开始位置
		int begin = (currentPage-1)*pageCount;
		
		//封装每页记录的list集合
		List<Customer> list = customerDao.findPage(begin,pageCount);
		pageBean.setList(list);
		return pageBean;
	}
	/*条件查询*/
	public List<Customer> select(Customer customer) {
		return customerDao.select(customer);
	}
	
	
}
