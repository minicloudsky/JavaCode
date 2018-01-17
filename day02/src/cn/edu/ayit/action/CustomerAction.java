package cn.edu.ayit.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.ayit.antity.Customer;
import cn.edu.ayit.antity.PageBean;
import cn.edu.ayit.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/*到添加页面*/
	public String toAddPage() {
		return "toAddPage";
	}
	/*添加客户*/
	public String add() {
		customerService.add(customer);
		return "add";
	}
	/*
	 * 封装表单数据
	 * */
	Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	/*
	 * 客户列表
	 * */
	public String list() {
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	/*删除客户*/
	public String delete() {
		int cid = customer.getCid();
		//根据cid进行查询
		Customer c = customerService.findOne(cid);
		//删除客户
		customerService.delete(c);
		return "delete";
	}
	/*到编辑页面*/
	public String find() {
		int cid = customer.getCid();
		Customer customer = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer",customer);
		return "find";
	}
	/*编辑客户*/
	public String edit() {
		customerService.keep(customer);
		return "edit";
	}
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	/*分页列表*/
	public String listPage() {
		//调用service中的方法对数据进行封装
		PageBean pageBean = customerService.listPage(currentPage);
		//放到域对象中
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	/*到条件查询页面*/
	public String toSelectPage() {
		return "toSelectPage";
	}
	/*条件查询*/
	public String select() {
		List<Customer> list = customerService.select(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "select";
	}
}
