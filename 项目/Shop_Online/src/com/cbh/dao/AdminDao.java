package com.cbh.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cbh.domain.Category;
import com.cbh.domain.Order;
import com.cbh.domain.Product;
import com.cbh.domain.User;
import com.cbh.utils.CommonsUtils;
import com.cbh.utils.DataSourceUtils;

public class AdminDao {

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return runner.query(sql, new BeanListHandler<Category>(Category.class));
	}

	public void saveProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),
				product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid());
	}

	public List<Order> findAllOrders() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders";
		return runner.query(sql, new BeanListHandler<Order>(Order.class));
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select p.pimage,p.pname,p.shop_price,i.count,i.subtotal "+
					" from orderitem i,product p "+
					" where i.pid=p.pid and i.oid=? ";
		return runner.query(sql, new MapListHandler(), oid);
	}

	public void addCategory(String categoryName) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into category values(?,?)";
		runner.update(sql, CommonsUtils.getUUID(),categoryName);
	}

	public void delCategory(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from category where cid=?";
		runner.update(sql,cid);
	}

	public List<Product> findAllProducts() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		return runner.query(sql, new BeanListHandler<Product>(Product.class));
	}

	public void delProduct(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid=?";
		runner.update(sql,pid);
	}

	public void updateProduct(Product p) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,pdesc=?,market_price=?,shop_price=?,is_hot=? where pid=?";
		runner.update(sql,p.getPname(),p.getPdesc(),p.getMarket_price(),p.getShop_price(),p.getIs_hot(),p.getPid());
	}

	public void addUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(user);
		runner.update(sql, user.getUid(),
				user.getUsername(),
				user.getPassword(),user.getName(),
				user.getEmail(),
				user.getTelephone(),
				user.getBirthday(),
				user.getSex(),
				user.getState(),
				user.getCode(),null,null);
	}

	public List<User> findAllUsers() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		return runner.query(sql, new BeanListHandler<User>(User.class));
	}

	public void updateUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username=?,password=?,name=?,telephone=?,email=? where uid=?";
		runner.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),user.getEmail(),user.getUid());
	}

	public void delUser(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where uid=?";
		runner.update(sql,uid);
	}

	public List<Map<String, Object>> findAllComments() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select c.id,u.uid,u.username,p.pname,c.pid,c.contents,c.datetime,c.reply from comments c,user u,product p where c.uid=u.uid and c.pid=p.pid";
		return runner.query(sql, new MapListHandler());
	}

	public void updateComment(String id, String reply) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update comments set reply=? where id=?";
		runner.update(sql,reply,id);
	}

	public int login(String u,String p) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from admin where username=? and password=?";
		Long l = (Long)runner.query(sql,new ScalarHandler(),u,p);
		return l.intValue();
	}
}
