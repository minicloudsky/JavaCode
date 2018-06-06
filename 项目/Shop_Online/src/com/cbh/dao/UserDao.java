package com.cbh.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.cbh.domain.User;
import com.cbh.utils.DataSourceUtils;

public class UserDao {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int regist(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int update = runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
				user.getSex(),user.getState(),user.getCode(),null,null);
		return update;
	}

	/**
	 * 更新用户状态(激活)
	 * @param activeCode
	 * @throws SQLException
	 */
	public void active(String activeCode) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state=? where code=?";
		runner.update(sql, 1,activeCode);
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User login(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return runner.query(sql, new BeanHandler<User>(User.class), username,password);
	}

	/**
	 * 通过uid更新用户信息
	 * @param uid
	 * @return 
	 * @return
	 * @throws SQLException 
	 */
	public User updateUserInfoByUid(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set password=?,name=?,email=?,telephone=?,birthday=?,address=?,receiver=? where uid = ?";
		runner.update(sql, user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getAddress(),user.getReceiver(),user.getUid());
		sql = "select * from user where uid=?";
		return runner.query(sql, new BeanHandler<User>(User.class), user.getUid());
	}

	public List<Map<String, Object>> findUserCommentsByUid(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select u.uid,u.username,p.pname,c.pid,c.contents,c.datetime,c.reply from comments c,user u,product p where c.uid=u.uid and c.pid=p.pid and c.uid=?";
		return runner.query(sql, new MapListHandler(), uid);
	}
}
