package com.cbh.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.cbh.dao.AdminDao;
import com.cbh.dao.UserDao;
import com.cbh.domain.Category;
import com.cbh.domain.Comments;
import com.cbh.domain.Order;
import com.cbh.domain.Product;
import com.cbh.domain.User;
import com.cbh.service.impl.AdminService;

public class AdminServiceImpl implements AdminService{

	public AdminServiceImpl() {
		
	}
	public List<Category> findAllCategory() {
		AdminDao dao = new AdminDao();
		try {
			return dao.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveProduct(Product product) throws SQLException {
		AdminDao dao = new AdminDao();
		dao.saveProduct(product);
	}

	public List<Order> findAllOrders() {
		AdminDao dao = new AdminDao();
		List<Order> ordersList = null;
		try {
			ordersList = dao.findAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) {
		AdminDao dao = new AdminDao();
		List<Map<String, Object>> mapList = null;
		try {
			mapList = dao.findOrderInfoByOid(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapList;
	}
	public void addCategory(String categoryName) {
		AdminDao dao = new AdminDao();
		try {
			dao.addCategory(categoryName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delCategory(String cid) {
		AdminDao dao = new AdminDao();
		try {
			dao.delCategory(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Product> findAllProducts() {
		AdminDao dao = new AdminDao();
		List<Product> list= null;
		try {
			list = dao.findAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateProduct(Product product) {
		AdminDao dao = new AdminDao();
		try {
			dao.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean delProduct(String pid) {
		AdminDao dao = new AdminDao();
		boolean flag = true;
		try {
			dao.delProduct(pid);
		} catch (SQLException e) {
			flag = false;
		} finally {
			return flag;
		}
	}
	public void addUser(User user) {
		AdminDao dao = new AdminDao();
		try {
			System.out.println(user);
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<User> findAllUsers() {
		AdminDao dao = new AdminDao();
		List<User> usersList = null;
		try {
			usersList = dao.findAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	public void updateUser(User user) {
		AdminDao dao = new AdminDao();
		try {
			dao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean delUser(String uid) {
		AdminDao dao = new AdminDao();
		boolean flag = true;
		try {
			dao.delUser(uid);
		} catch (SQLException e) {
			flag = false;
		} finally {
			return flag;
		}
	}
	public List<Comments> findAllComments() {
		AdminDao dao = new AdminDao();
		List<Comments> list = new ArrayList<Comments>();
		try {
			List<Map<String, Object>> mapList = dao.findAllComments();
			for(Map<String,Object> map : mapList){
				Comments c = new Comments();
				BeanUtils.populate(c, map);
				list.add(c);
			}
		} catch (SQLException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateComment(String id, String reply) {
		AdminDao dao = new AdminDao();
		try {
			dao.updateComment(id,reply);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean login(String u, String p) {
		AdminDao dao = new AdminDao();
		boolean flag = false;
		try {
			flag = dao.login(u,p) > 0 ? true :false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
