package cn.edu.ayit.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.ayit.antity.User;

public class UserDao extends HibernateDaoSupport{
	@SuppressWarnings("all")
	public User login(User user) {
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		List<User> list = (List<User>) hibernateTemplate.find("from User where username = ? and password = ?",
				user.getUsername(),user.getPassword());
	
		if(list != null && list.size() != 0) {
			User u = list.get(0);
			return u;
		}else {
			return null;
		}
	}
	/*查询所有的用户*/
	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	
}
