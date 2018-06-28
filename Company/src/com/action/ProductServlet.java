package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Product;
import com.service.ProductService;

public class ProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productService=new ProductService();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Integer classify=Integer.parseInt(request.getParameter("classify"));
		System.out.println(request.getParameter("classify"));
		List<Product> list=productService.getProduct(classify);
		request.setAttribute("productlist",list);
		request.getRequestDispatcher("/jsp/topic2.jsp").forward(request, response);
	}

}
