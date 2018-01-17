package cn.edu.ayit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.ayit.antity.User;
import cn.edu.ayit.dao.UserDao;
@Transactional
public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User login(User user) {
		return userDao.login(user);
	}
	/*查询所有的用户*/
	public List<User> findAll() {
		return userDao.findAll();
	}
	
}
