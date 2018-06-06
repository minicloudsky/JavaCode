package com.cbh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

import com.cbh.domain.Cart;
import com.cbh.domain.CartItem;
import com.cbh.domain.Category;
import com.cbh.domain.Comments;
import com.cbh.domain.Order;
import com.cbh.domain.OrderItem;
import com.cbh.domain.PageBean;
import com.cbh.domain.Product;
import com.cbh.domain.User;
import com.cbh.service.ProductService;
import com.cbh.utils.CommonsUtils;
import com.cbh.utils.JedisPoolUtils;
import com.cbh.utils.PaymentUtil;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol.Command;

@WebServlet("/productServlet")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
	//首页
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService services = new ProductService();
		List<Product> hotProductList = services.findHotProductList();
		List<Product> newProductList = services.findNewProductList();
		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//导航栏
	public void categoryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Jedis jedis = JedisPoolUtils.getJedis();
//		String categoryListJson = jedis.get("categoryListJson");
//		if(categoryListJson == null) {
//			System.out.println("缓存没有数据,查询数据库");
//			ProductService service = new ProductService();
//			List<Category> categoryList = service.findAllCategory();
//			Gson gson = new Gson();
//			categoryListJson = gson.toJson(categoryList);
//			jedis.set("categoryListJson", categoryListJson);
//		}
		
		ProductService service = new ProductService();
		List<Category> categoryList = service.findAllCategory();
		Gson gson = new Gson();
		String categoryListJson = gson.toJson(categoryList);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);
	}
	
	//商品列表
	public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		
		ProductService service = new ProductService();
		PageBean pageBean = service.findProductListByCid(cid,Integer.parseInt(currentPage));
		
		request.setAttribute("cid", cid);
		request.setAttribute("pageBean", pageBean);
		
		List<Product> historyProductList = new ArrayList<Product>();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("pids".equals(cookie.getName())) {
					String pids = cookie.getValue();
					String[] split = pids.split("-");
					for(String pid : split) {
						Product pro = service.findProductByPid(pid);
						historyProductList.add(pro);
					}
				}
			}
		}
		request.setAttribute("historyProductList", historyProductList);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
	
	//商品详细信息
	public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String currentPage = request.getParameter("currentPage");
		String backUrl = "";
		if(currentPage == null) {
			backUrl = request.getContextPath()+"/productServlet?method=index";
		} else {
			backUrl = request.getContextPath()+"/productServlet?method=productList&cid="+cid+"&currentPage="+currentPage;
		}
		
		String pids = pid;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if("pids".equals(cookie.getName())) {
				pids = cookie.getValue();
				String[] split = pids.split("-");
				List<String> asList = Arrays.asList(split);
				LinkedList<String> list = new LinkedList<String>(asList);
				if(list.contains(pid)) {
					list.remove(pid);
				}
				list.addFirst(pid);
				
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<list.size()&&i<7; i++) {
					sb.append(list.get(i));
					sb.append("-");
				}
				pids = sb.substring(0,sb.length()-1);
			}
		}
		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);
		
		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		List<Comments> commentsList = service.findAllCommentsByPid(pid);
		
		request.setAttribute("comments",commentsList);
		request.setAttribute("product",product);
		request.setAttribute("cid",cid);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("backUrl",backUrl);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}
	
	//添加购物车
	public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pid = request.getParameter("pid");
		String buyNumStr = request.getParameter("buyNum");
		int buyNum;
		if(buyNumStr==null ||Integer.parseInt(buyNumStr) < 1) buyNum = 1;
		else buyNum = Integer.parseInt(buyNumStr);
		ProductService service = new ProductService();
		Product product = service.findProductByPid(pid);
		double subtotal = product.getShop_price() * buyNum;
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setBuyNum(buyNum);
		cartItem.setSubtotal(subtotal);
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
		}
		Map<String,CartItem> cartItems = cart.getCartItems();
		if(cartItems.containsKey(pid)) {
			CartItem item = cartItems.get(pid);
			int oldBuyNum = item.getBuyNum();
			oldBuyNum += buyNum;
			item.setBuyNum(oldBuyNum);
			double oldSubtotal = item.getSubtotal() + subtotal;
			item.setSubtotal(oldSubtotal);
		}else {
			cart.getCartItems().put(product.getPid(), cartItem);
		}
		double total = cart.getTotal() + subtotal;
		cart.setTotal(total);
		
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}
	
	//删除购物车单个商品
	public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			Map<String,CartItem> cartItem = cart.getCartItems();
			double total = cart.getTotal() - cartItem.get(pid).getSubtotal();
			cart.setTotal(total);
			cartItem.remove(pid);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}
	
	//清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}
	
	//提交订单
	public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			 response.sendRedirect(request.getContextPath()+"/login.jsp");
			 return;
		}
		
		Order order = new Order();
		String oid = CommonsUtils.getUUID();
		
		order.setOid(oid);
		order.setOrderTime(new Date());
		
		double total = 0;
		Map<String,CartItem> cartItems = null;
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			total = cart.getTotal();
			cartItems = cart.getCartItems();
		}
		order.setTotal(total);
		order.setState(0);
		
		order.setName(null);
		order.setAddress(null);
		order.setTelephone(null);
		
		order.setUser(user);
		for(Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
			CartItem cartItem = entry.getValue();
			OrderItem item = new OrderItem();
			item.setItemid(CommonsUtils.getUUID());
			item.setCount(cartItem.getBuyNum());
			item.setSubtotal(cartItem.getSubtotal());
			item.setProduct(cartItem.getProduct());
			item.setOrder(order);
			
			order.getOrderItems().add(item);
		}
		
		ProductService service = new ProductService();
		service.submiyOrder(order);
		session.setAttribute("order", order);
		session.removeAttribute("cart");
		response.sendRedirect(request.getContextPath()+"/order_info.jsp");
	}
	
	//确认订单
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String[]> properties = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		ProductService service = new ProductService();
		service.updateOrderAddr(order);
//---------------------------------------------------------------------------------
		pay(request,response,order);
	}
	
	private void pay(HttpServletRequest request, HttpServletResponse response,Order order) throws IOException {
		// 获得 支付必须基本数据
		String orderid = request.getParameter("oid");
//		String money = order.getTotal()+"";
//		// 银行
//		String pd_FrpId = request.getParameter("pd_FrpId");
//
//		// 发给支付公司需要哪些数据
//		String p0_Cmd = "Buy";
//		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
//		String p2_Order = orderid;
//		String p3_Amt = money;
//		String p4_Cur = "CNY";
//		String p5_Pid = "";
//		String p6_Pcat = "";
//		String p7_Pdesc = "";
//		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
//		// 第三方支付可以访问网址
//		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
//		String p9_SAF = "";
//		String pa_MP = "";
//		String pr_NeedResponse = "1";
//		// 加密hmac 需要密钥
//		String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
//				"keyValue");
//		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
//				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
//				pd_FrpId, pr_NeedResponse, keyValue);
//		
//				String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
//								"&p0_Cmd="+p0_Cmd+
//								"&p1_MerId="+p1_MerId+
//								"&p2_Order="+p2_Order+
//								"&p3_Amt="+p3_Amt+
//								"&p4_Cur="+p4_Cur+
//								"&p5_Pid="+p5_Pid+
//								"&p6_Pcat="+p6_Pcat+
//								"&p7_Pdesc="+p7_Pdesc+
//								"&p8_Url="+p8_Url+
//								"&p9_SAF="+p9_SAF+
//								"&pa_MP="+pa_MP+
//								"&pr_NeedResponse="+pr_NeedResponse+
//								"&hmac="+hmac;
		String url = "http://localhost:8080/Shop_Online/pay?method=payBack&oid="+orderid;
		//重定向到第三方支付平台
		response.sendRedirect(url);
	}
	//订单结算
	public void payProOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String oid = request.getParameter("oid");
		ProductService service = new ProductService();
		Order order = service.findProOrderByOid(oid);
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
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		response.sendRedirect(request.getContextPath()+"/order_info.jsp");
	}
	
	

	public void myOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		    return;
		}
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) currentPage = "1";
		ProductService service = new ProductService();
		PageBean pageBean = service.findOrdersListByPage(user.getUid(),Integer.parseInt(currentPage));
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
		if(request.getParameter("page").equals("1")) {
			request.getRequestDispatcher("/order_list.jsp").forward(request, response);
		}
		else if(request.getParameter("page").equals("2")) {
			request.getRequestDispatcher("/usercenter/orders.jsp").forward(request, response);
		}
	}
	//删除订单
	public void delProOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String oid = request.getParameter("oid");
		ProductService service = new ProductService();
		service.delProOrder(oid);
		myOrders(request,response);
	}
	public void productComment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		    return;
		}
		
		String contents = request.getParameter("contents");
		String pid = request.getParameter("pid");
		Comments comments = new Comments();
		comments.setId(CommonsUtils.getUUID());
		comments.setUid(user.getUid());
		comments.setContents(contents);
		comments.setPid(pid);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comments.setDatetime(format.format(new Date()));
		
		ProductService service = new ProductService();
		service.addComment(comments);
		productInfo(request, response);
	}
}

