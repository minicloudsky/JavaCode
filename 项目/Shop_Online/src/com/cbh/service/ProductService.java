package com.cbh.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.cbh.dao.ProductDao;
import com.cbh.domain.Category;
import com.cbh.domain.Comments;
import com.cbh.domain.Order;
import com.cbh.domain.OrderItem;
import com.cbh.domain.PageBean;
import com.cbh.domain.Product;
import com.cbh.utils.DataSourceUtils;

public class ProductService {

	public List<Product> findHotProductList() {

		ProductDao dao = new ProductDao();
		List<Product> hotProductList = null;
		try {
			hotProductList = dao.findHotProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotProductList;
	}

	public List<Product> findNewProductList() {
		ProductDao dao = new ProductDao();
		List<Product> newProductList = null;
		try {
			newProductList = dao.findNewProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newProductList;
	}

	public List<Category> findAllCategory() {
		ProductDao dao = new ProductDao();
		List<Category> categoryList = null;
		try {
			categoryList = dao.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	public PageBean findProductListByCid(String cid, int currentPage) {
		ProductDao dao = new ProductDao();

		PageBean<Product> pageBean = new PageBean<Product>();
		int currentCount = 12;
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);

		int totalCount = 0;
		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);

		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);

		int index = (currentPage - 1) * currentCount;
		List<Product> list = null;
		try {
			list = dao.findProductByPage(cid, index, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setList(list);

		return pageBean;
	}

	public int findProductCountByCid(String cid) {
		ProductDao dao = new ProductDao();
		int count = 0;
		try {
			count = dao.getCount(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public Product findProductByPid(String pid) {
		ProductDao dao = new ProductDao();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public boolean submiyOrder(Order order) {
		boolean flag = true;
		ProductDao dao = new ProductDao();
		try {
			DataSourceUtils.startTransaction();
			dao.addOrders(order);
			dao.addOrderItem(order.getOrderItems());
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
	}

	public void updateOrderAddr(Order order) {
		ProductDao dao = new ProductDao();
		try {
			dao.updateOrderAddr(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOrderState(String order) {
		ProductDao dao = new ProductDao();
		try {
			dao.updateOrderState(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> findAllOrders(String uid) {
		ProductDao dao = new ProductDao();
		List<Order> orderList = null;
		try {
			orderList = dao.findAllOrders(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	public List<Map<String, Object>> findAllOrderItemByOid(String oid) {
		ProductDao dao = new ProductDao();
		List<Map<String, Object>> mapList = null;
		try {
			mapList = dao.findAllOrderItemByOid(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapList;
	}

	public void delProOrder(String oid) {
		ProductDao dao = new ProductDao();
		try {
			dao.delProOrder(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PageBean findOrdersListByPage(String uid,int currentPage) {
		ProductDao dao = new ProductDao();

		PageBean<Order> pageBean = new PageBean<Order>();
		int currentCount = 5;
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);

		int totalCount = 0;
		try {
			totalCount = dao.getOrdersCount(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);

		int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
		pageBean.setTotalPage(totalPage);

		int index = (currentPage - 1) * currentCount;
		List<Order> list = null;
		try {
			list = dao.findOrdersByPage(uid, index, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setList(list);
		return pageBean;
	}

	public List<Comments> findAllCommentsByPid(String pid) {
		ProductDao dao = new ProductDao();
		List<Comments> list = new ArrayList<Comments>();
		try {
			List<Map<String, Object>> mapList = dao.findAllCommentsByPid(pid);
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

	public void addComment(Comments comments) {
		ProductDao dao = new ProductDao();
		try {
			dao.addComment(comments);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PageBean findOrdersListByPage(int currentPage) {
		ProductDao dao = new ProductDao();

		PageBean<Order> pageBean = new PageBean<Order>();
		int currentCount = 5;
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);

		int totalCount = 0;
		try {
			totalCount = dao.getOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);

		int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
		pageBean.setTotalPage(totalPage);

		int index = (currentPage - 1) * currentCount;
		List<Order> list = null;
		try {
			list = dao.findOrdersByPage(index, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setList(list);
		return pageBean;
	}

	public Order findProOrderByOid(String oid) {
		ProductDao dao = new ProductDao();
		Order order = null;
		try {
			order=dao.findProOrderByOid(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
