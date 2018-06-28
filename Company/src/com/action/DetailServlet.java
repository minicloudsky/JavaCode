package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Product;
import com.service.ProductService;

public class DetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productService=new ProductService();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int pid=Integer.parseInt(request.getParameter("id"));
		Product product=productService.getDetail(pid);
		request.setAttribute("product",product);
		request.getRequestDispatcher("/jsp/topic2-1.jsp").forward(request, response);
	}

}
