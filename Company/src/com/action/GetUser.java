package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.ProductService;

public class GetUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productService=new ProductService();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<User> list=productService.getUser();
		request.setAttribute("userlist",list);
		request.getRequestDispatcher("/jsp/topic3.jsp").forward(request, response);
	}

}
