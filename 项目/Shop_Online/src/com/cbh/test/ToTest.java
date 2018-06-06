package com.cbh.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.cbh.dao.ProductDao;
import com.cbh.dao.UserDao;
import com.cbh.domain.User;
import com.cbh.service.UserService;

public class ToTest {

	@Test
	public void test() throws SQLException, ParseException {
		UserDao d = new UserDao();
		User login = d.login("changbaihe", "1234");
		login.setTelephone("110");
		UserService s = new UserService();
		login = s.updateUserInfoByUid(login);
		System.out.println(s.updateUserInfoByUid(login));
	}
}
