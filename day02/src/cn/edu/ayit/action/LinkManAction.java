package cn.edu.ayit.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.ayit.antity.Customer;
import cn.edu.ayit.antity.LinkMan;
import cn.edu.ayit.service.CustomerService;
import cn.edu.ayit.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/*封装表单数据到linkMan对象中*/
	LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	/*
	 * 到添加页面
	 * */
	public String toAddPage() {
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddPage";
	}
	/*
	 * 添加联系人
	 * */
	/*
	public String add() throws IOException {
		linkManService.add(linkMan);
		//判断是否需要上传文件
		if(upLoad != null) {
			//在服务器文件夹里面创建文件
			File serverFile = new File("E:\\文件"+"/"+upLoadFileName);
			//把上传文件复制到服务器文
			FileUtils.copyFile(upLoad, serverFile);
		}
		return "add";
	}*/
	
	/*联系人列表*/
	public String list() {
		List<LinkMan> list = linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	/*到修改页面*/
	public String toUpdatePage() {
		int id = linkMan.getLkmId();
		LinkMan linkMan =  linkManService.findById(id);
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("linkman", linkMan);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toUpdatePage";
	}
	/*修改*/
	public String update() {
		linkManService.update(linkMan);
		return "update";
	}
	/*条件查询页面*/
	public String toSelectPage() {
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list",list);
		return "toSelectPage";
	}
	/*条件查询*/
	public String select() {
		List<LinkMan> list = linkManService.select(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "select";
	}
}
