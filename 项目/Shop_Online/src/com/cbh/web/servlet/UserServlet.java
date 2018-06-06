package com.cbh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.cbh.domain.Comments;
import com.cbh.domain.User;
import com.cbh.service.UserService;
import com.cbh.utils.CommonsUtils;
import com.cbh.utils.MailUtils;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null && password==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		String checkCode = request.getParameter("checkCode");
		String checkCode_Session = (String) session.getAttribute("checkCode_Session");
		
		String loginError = "用户名或密码错误";
		if(!checkCode.equals(checkCode_Session)) {
			loginError = "验证码不正确";
			request.setAttribute("loginError", loginError);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//对密码进行加密
		//password = MD5Utils.md5(password);
		UserService service = new UserService();
		User user = null;
		
		user = service.login(username,password);
		if(user != null) {
			if(user.getState() == 0) {
				loginError = "用户未激活";
				user = null;
			}
		}

		//判断用户是否登录成功 user是否是null
		if(user!=null){
			String autoLogin = request.getParameter("autoLogin");
			if("on".equals(autoLogin)){
				//要自动登录
				//创建存储用户名的cookie
				Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
				cookie_username.setMaxAge(10*60);
			//创建存储密码的cookie
				Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
				cookie_password.setMaxAge(10*60);

				response.addCookie(cookie_username);
				response.addCookie(cookie_password);

			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/Default.jsp");
		}else{
			request.setAttribute("loginError", loginError);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * 用户注销
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		Cookie cusername = new Cookie("cookie_username","");
		cusername.setMaxAge(0);
		//创建存储密码的cookie
		Cookie cpassword = new Cookie("cookie_password","");
		cpassword.setMaxAge(0);
		response.addCookie(cusername);
		response.addCookie(cpassword);
		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class clazz, Object value) {
				Date parse = null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					parse = format.parse(value.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(parse.toString());
				return parse;
			}
		}, Date.class);
		
		request.setCharacterEncoding("UTF-8");
		// 获取表单数据
		Map<String, String[]> paramsMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, paramsMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(CommonsUtils.getUUID());
		user.setTelephone(null);
		user.setState(0);
		user.setCode(CommonsUtils.getUUID());

		String checkCode = request.getParameter("checkCode");
		String checkCode_Session = (String) request.getSession().getAttribute("checkCode_Session");
		if(!checkCode.equals(checkCode_Session)) {
			request.setAttribute("loginError", "验证码不正确");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		// 将user传递给service层
		UserService service = new UserService();
		boolean isRegisterSuccess = service.regist(user);

		String activeCode = user.getCode();
		// 是否注册成功
		if (isRegisterSuccess) {
			String emailMsg = "恭喜您注册成功,请点击下面的链接进行激活帐户<a href='http://127.0.0.1:8080/Shop_Online/userServlet?method=active&activeCode="+ activeCode +"'>"
		+ "http://127.0.0.1:8080/Shop_Online/userServlet?method=active&activeCode=" + activeCode + "</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/register_S.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/register_F.jsp");
		}
	}
	
	/**
	 * 用户激活
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String activeCode = request.getParameter("activeCode");
		UserService service = new UserService();
		service.active(activeCode);
		response.sendRedirect(request.getContextPath()+"/activeRedirect.jsp");;
	}
	
	/**
	 * 更新用户信息
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 获取表单数据
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class clazz, Object value) {
				Date parse = null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					parse = format.parse(value.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return parse;
			}
		}, Date.class);
		
		Map<String, String[]> paramsMap = request.getParameterMap();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		try {
			BeanUtils.populate(user, paramsMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		UserService service = new UserService();
		user = service.updateUserInfoByUid(user);
		session.setAttribute("user", user);
		
		if(request.getParameter("page").equals("1")) {
			request.setAttribute("update_result", "success");
			request.getRequestDispatcher("/usercenter/userInfo.jsp").forward(request, response);
		}
		else if(request.getParameter("page").equals("2")) {
			request.setAttribute("address_result", "success");
			request.getRequestDispatcher("/usercenter/address.jsp").forward(request, response);
		}
	}
	
	/**
	 * 查询当前用户所有的评论
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void myComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		UserService service = new UserService();
		List<Comments> list = service.findUserCommentsByUid(user.getUid());
		request.setAttribute("comments", list);
		request.getRequestDispatcher("/usercenter/comments.jsp").forward(request, response);
	}
}
