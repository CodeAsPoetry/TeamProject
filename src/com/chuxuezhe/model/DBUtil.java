package com.chuxuezhe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/team_project?useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="pcj495131";
	
	private static Connection conn =null;

	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		    //2.获得数据库的连接
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
//	public static void main(String args[]) {
//		Connection conn =DBUtil.getConnection();
//		System.out.print(conn);
//	}

}
