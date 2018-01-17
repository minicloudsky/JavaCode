package cn.edu.ayit.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.ayit.antity.User;
import cn.edu.ayit.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() {
		User userExit = userService.login(user);
		if(userExit != null) {
			//保存用户到session域中
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", userExit);
			return "index";
		}else {
			return "login";
		}
	}
	/*
	 * 封装请求数据
	 * */
	User user = new User();
	public User getModel() {
		return user;
	}
	/*退出登录*/
	public String out() {
		return "out";
	}
}
