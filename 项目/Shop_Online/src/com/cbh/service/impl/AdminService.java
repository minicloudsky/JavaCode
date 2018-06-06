package com.cbh.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cbh.domain.Category;
import com.cbh.domain.Order;
import com.cbh.domain.Product;

public interface AdminService {

	public List<Category> findAllCategory();

	public void saveProduct(Product product) throws SQLException;

	public List<Order> findAllOrders();

	public List<Map<String, Object>> findOrderInfoByOid(String oid);

}
