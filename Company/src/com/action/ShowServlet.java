package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Img;
import com.service.ProductService;

public class ShowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productService=new ProductService();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Integer count=Integer.parseInt(request.getParameter("count"));
		Img pimg=productService.getImg(count);
		request.setAttribute("pimg",pimg);
		request.getRequestDispatcher("/jsp/topic5-1.jsp").forward(request, response);
	}

}
