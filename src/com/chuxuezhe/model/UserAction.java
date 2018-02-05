package com.chuxuezhe.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.chuxuezhe.entity.User;
import com.chuxuezhe.model.UserDao;

public class UserAction {
	public void add(User user) throws SQLException{
		UserDao dao = new UserDao();
		dao.addUser(user);
	}
	public User get(Integer id) throws SQLException{
		UserDao dao = new UserDao();
		return dao.get(id);
	} 
	
	public void edit(User user) throws SQLException{
		UserDao dao = new UserDao();
		dao.updateUser(user);
	}
	
	public void del(Integer id) throws SQLException{
		UserDao dao = new UserDao();
		dao.delUser(id);
	}
	
	public List<User> query() throws SQLException{
		UserDao dao = new UserDao();
		return dao.query();
	}
	
	public List<User> query(List<Map<String,Object>> params) throws SQLException{
		UserDao dao = new UserDao();
		return dao.query(params);
	}
	


}
