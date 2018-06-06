package com.cbh.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.cbh.dao.UserDao;
import com.cbh.domain.Comments;
import com.cbh.domain.User;

public class UserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean regist(User user) {
		UserDao dao = new UserDao();
		int row = 0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row>0?true:false;
	}

	/**
	 * 用户激活
	 * @param activeCode
	 */
	public void active(String activeCode) {
		UserDao dao = new UserDao();
		try {
			dao.active(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User login(String username, String password){
		UserDao dao = new UserDao();
		User user = null;
		try {
			user = dao.login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public User updateUserInfoByUid(User user) {
		UserDao dao = new UserDao();
		User user_back = null;
		try {
			user_back = dao.updateUserInfoByUid(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_back;
	}

	public List<Comments> findUserCommentsByUid(String uid) {
		UserDao dao = new UserDao();
		List<Comments> list = new ArrayList<Comments>();
		try {
			List<Map<String, Object>> mapList = dao.findUserCommentsByUid(uid);
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
}
