package com.service;

import java.util.List;

import com.dao.ProductDao;
import com.domain.Img;
import com.domain.Product;
import com.domain.User;

public class ProductService {
	ProductDao productDao=new ProductDao();
	public List<Product> getProduct(Integer classify) {
		
		List<Product> list=productDao.getProduct(classify);
		return list;
	}

	public Product getDetail(int pid) {
		Product product=productDao.getDetail(pid);
		return product;
	}

	public void save(User user) {
		productDao.save(user);
	}

	public List<User> getUser() {
		List<User> list=productDao.getUser();
		return list;
	}

	public Img getImg(Integer count) {
		Img pimg=productDao.getImg(count);
		return pimg;
	}
}
