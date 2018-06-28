package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.Conn;
import com.domain.Img;
import com.domain.Product;
import com.domain.User;

public class ProductDao {
	Conn conn=new Conn();
	public List<Product> getProduct(Integer classify) {
		List<Product> list=new ArrayList<Product>();
		String sql="select * from product where classify='"+classify+"'";
		ResultSet rs=conn.executeQuery(sql);
		try {
			while(rs.next()){
				Product product=new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setImg(rs.getString("img"));
				product.setWeight(rs.getString("weight"));
				product.setArea(rs.getString("area"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		return list;
	}
	public Product getDetail(int pid) {
		String sql="select * from product where pid='"+pid+"'";
		ResultSet rs=conn.executeQuery(sql);
		Product product=new Product();
		try {
			while(rs.next()){
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setImg(rs.getString("img"));
				product.setWeight(rs.getString("weight"));
				product.setArea(rs.getString("area"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return product;
	}
	public void save(User user) {
		String sql="insert into customer values('"+user.getName()+"','"+user.getAge()+"','"+user.getSex()+"','"+user.getText()+"')";
		conn.executeUpdate(sql);
		conn.close();
	}
	public List<User> getUser() {
		List<User> list=new ArrayList<User>();
		String sql="select * from customer";
		ResultSet rs=conn.executeQuery(sql);
		try {
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setText(rs.getString("text"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		return list;
	}
	public Img getImg(Integer count) {
		Img pimg=new Img();
		String sql="select * from descp where count='"+count+"'";
		System.out.println(sql);
		ResultSet rs=conn.executeQuery(sql);
		try {
			while(rs.next()){
			
				pimg.setImg(rs.getString("img"));
				pimg.setCount(rs.getInt("count"));
				pimg.setDesc(rs.getString("desc"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return pimg;
	}

}
