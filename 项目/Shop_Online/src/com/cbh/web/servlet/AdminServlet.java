package com.cbh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.cbh.domain.Category;
import com.cbh.domain.Comments;
import com.cbh.domain.Order;
import com.cbh.domain.OrderItem;
import com.cbh.domain.PageBean;
import com.cbh.domain.Product;
import com.cbh.domain.User;
import com.cbh.service.AdminServiceImpl;
import com.cbh.service.ProductService;
import com.cbh.service.UserService;
import com.cbh.service.impl.AdminService;
import com.cbh.utils.BeanFactory;
import com.cbh.utils.CommonsUtils;
import com.google.gson.Gson;

@WebServlet("/admins")
public class AdminServlet extends BaseServlet {
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminServiceImpl service = new AdminServiceImpl();
		boolean flag = service.login(username,password);
		HttpSession session = request.getSession();
		if(flag) {
			session.setAttribute("admin", username);
			response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
		}else {
			request.setAttribute("result", "用户名密码错误");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
		
	}
	public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		response.sendRedirect(request.getContextPath()+"/index_admin.jsp");
	}
	//根据订单id查询订单项和商品信息
	public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//获得oid
		String oid = request.getParameter("oid");
		AdminServiceImpl service = new AdminServiceImpl();
		List<Map<String,Object>> mapList = service.findOrderInfoByOid(oid);
		
		Gson gson = new Gson();
		String json = gson.toJson(mapList);
		System.out.println(json);
		/*[
		 * 	{"shop_price":4499.0,"count":2,"pname":"联想（Lenovo）小新V3000经典版","pimage":"products/1/c_0034.jpg","subtotal":8998.0},
		 *  {"shop_price":2599.0,"count":1,"pname":"华为 Ascend Mate7","pimage":"products/1/c_0010.jpg","subtotal":2599.0}
		 *]*/
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		
	}
	
	//获得所有的订单
	public void findAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所有的订单信息----List<Order>
		
		AdminServiceImpl service = new AdminServiceImpl();
		List<Order> orderList = service.findAllOrders();
		
		request.setAttribute("orderList", orderList);
		
		request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);
		
	}

	public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//提供一个List<Category> 转成json字符串
		AdminServiceImpl service = new AdminServiceImpl();
		List<Category> categoryList = service.findAllCategory();
		
		Gson gson = new Gson();
		String json = gson.toJson(categoryList);
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(json);
		
	}

	public void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String categoryName = request.getParameter("categoryName");
		AdminServiceImpl service = new AdminServiceImpl();
		service.addCategory(categoryName);
		
		String flag = "success";
		Gson gson = new Gson();
		String json = gson.toJson(flag);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		AdminServiceImpl service = new AdminServiceImpl();
		service.delCategory(cid);
		
		String flag = "success";
		Gson gson = new Gson();
		String json = gson.toJson(flag);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl service = new AdminServiceImpl();
		List<Product> list = service.findAllProducts();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> paramsMap = request.getParameterMap();
		Product product = new Product();
		try {
			BeanUtils.populate(product, paramsMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		AdminServiceImpl service = new AdminServiceImpl();
		service.updateProduct(product);
		Gson gson = new Gson();
		String json = gson.toJson("success");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void delProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		AdminServiceImpl service = new AdminServiceImpl();
		boolean flag = service.delProduct(pid);
		String result = "success";
		if(flag == false) result = "该商品存在订单，请勿删除!";
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void myOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		ProductService service = new ProductService();
		PageBean pageBean = service.findOrdersListByPage(Integer.parseInt(currentPage));
		List<Order> orderList = pageBean.getList();
		if(orderList!=null){
			for(Order order : orderList){
				String oid = order.getOid();
				List<Map<String, Object>> mapList = service.findAllOrderItemByOid(oid);
				for(Map<String,Object> map : mapList){
					
					try {
						OrderItem item = new OrderItem();
						BeanUtils.populate(item, map);
						
						Product product = new Product();
						BeanUtils.populate(product, map);
						
						item.setProduct(product);
						order.getOrderItems().add(item);
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}
	
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map<String, String[]> paramsMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, paramsMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(CommonsUtils.getUUID());
		user.setBirthday(new Date());
		user.setState(1);
		System.out.println(user);
		AdminServiceImpl service = new AdminServiceImpl();
		service.addUser(user);
		Gson gson = new Gson();
		String json = gson.toJson("success");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void findAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AdminServiceImpl service = new AdminServiceImpl();
		List<User> list = service.findAllUsers();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> paramsMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, paramsMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		AdminServiceImpl service = new AdminServiceImpl();
		service.updateUser(user);
		Gson gson = new Gson();
		String json = gson.toJson("success");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		AdminServiceImpl service = new AdminServiceImpl();
		boolean flag = service.delUser(uid);
		String result = "success";
		if(flag == false) result = "该用户存在订单，请勿删除!";
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void findAllComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminServiceImpl service = new AdminServiceImpl();
		List<Comments> list = service.findAllComments();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
	
	public void updateComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String reply = request.getParameter("reply");
		System.out.println(id+":"+reply);
		AdminServiceImpl service = new AdminServiceImpl();
		service.updateComment(id,reply);
		String result = "success";
		Gson gson = new Gson();
		String json = gson.toJson(result);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
}
