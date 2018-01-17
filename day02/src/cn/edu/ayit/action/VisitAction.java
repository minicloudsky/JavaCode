package cn.edu.ayit.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.ayit.antity.Customer;
import cn.edu.ayit.antity.User;
import cn.edu.ayit.antity.Visit;
import cn.edu.ayit.service.CustomerService;
import cn.edu.ayit.service.UserService;
import cn.edu.ayit.service.VisitService;

@SuppressWarnings("all")
public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	@SuppressWarnings("all")
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/*封装请求数据*/
	Visit visit = new Visit();
	public Visit getModel() {
		return visit;
	}
	/*到新增客户拜访页面*/
	public String toAddPage() {
		//查询出所有的客户
		List<Customer> customerList = customerService.findAll();
		//查询出所有的用户
		List<User> userList = userService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customerList", customerList);
		request.setAttribute("userList", userList);
		return "toAddPage";
	}
	/*添加到数据库*/
	public String add() {
		visitService.add(visit);
		return "add";
	}
	/*列表*/
	public String list() {
		List<Visit> list = visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list",list);
		return "list";
	}
	/*到修改页面*/
	public String toUpdatePage() {
		int vid = visit.getVid();
		//根据vid查询visit
		Visit v = visitService.findById(vid);
		//查询所有的用户
		List<User> listUser = userService.findAll();
		//查询所有的客户
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("visit", v);
		ServletActionContext.getRequest().setAttribute("listUser", listUser);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toUpdatePage";
	}
	/*修改*/
	public String update() {
		visitService.edit(visit);
		return "update";
	}
	
}
