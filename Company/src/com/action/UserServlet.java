package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.ProductService;

public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productService=new ProductService();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
		int age=Integer.parseInt(request.getParameter("age"));
		String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
		String text=new String(request.getParameter("text").getBytes("ISO-8859-1"),"utf-8");
		User user=new User();
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
		user.setText(text);
		productService.save(user);
		response.getWriter().println("<script>alert('用户反馈成功!');location='jsp/index.jsp';</script>");
	}

}
