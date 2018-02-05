package com.chuxuezhe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chuxuezhe.entity.User;

public class UserDao {
	public void addUser(User user) throws SQLException{
		Connection conn =DBUtil.getConnection();
		String sql = ""+
		             "insert into user_reg_login"+
				     "(username,password,telephone,email,sex)"+
				     "values("+
		             "?,?,?,?,?)";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, user.getUsername());
		ptmt.setString(2, user.getPassword());
		ptmt.setString(3, user.getTelephone());
		ptmt.setString(4, user.getEmail());
		ptmt.setInt(5, user.getSex());
		
		
		ptmt.execute();
		
	}
	
	public void updateUser(User user) throws SQLException{
		Connection conn =DBUtil.getConnection();
		String sql = " update user_reg_login "+
				     " set username=?,password=?,telephone=?,email=?,sex=?"+
				     " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, user.getUsername());
		ptmt.setString(2, user.getPassword());
		ptmt.setString(3, user.getTelephone());
		ptmt.setString(4, user.getEmail());
		ptmt.setInt(5, user.getSex());
		
		
		ptmt.execute();
		
	}
	
	public void delUser(Integer id) throws SQLException{
		Connection conn =DBUtil.getConnection();
		String sql = ""+
		             " delete from user_reg_login "+
				     " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		
		ptmt.execute();
	}
	
	public List<User> query() throws SQLException{
		Connection conn =DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("select username,id from user_reg_login");
		
		List<User> users = new ArrayList<User>();
		User user =null;
		while(rs.next()){
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setId(rs.getInt("id"));
			users.add(user);
		}
		return users;
	}
	
	public User get(Integer id) throws SQLException{
		User user = null;
		Connection conn =DBUtil.getConnection();
		String sql = ""+
		             " select * from user_reg_login "+
				     " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		
		ResultSet rs =ptmt.executeQuery(); 
		while(rs.next()){
			user = new User();
			
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTelephone(rs.getString("telephone"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getInt("sex"));
						
		}
		return user;
	}
	
	public List<User> query(List<Map<String,Object>> params) throws SQLException{
		List<User> result = new ArrayList<User>();
		
		Connection conn =DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from user_reg_login where 1=1  ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
			}
		}
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		
		User user =null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTelephone(rs.getString("telephone"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getInt("sex"));
			
			result.add(user);
		}
		return result;
	}


}
