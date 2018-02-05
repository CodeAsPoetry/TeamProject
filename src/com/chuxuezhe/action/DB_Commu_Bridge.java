package com.chuxuezhe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.chuxuezhe.model.UserAction;
import com.chuxuezhe.entity.User;

public class DB_Commu_Bridge {

	public boolean register(JSONObject jsonobject) {
		boolean register_sucess = false ;
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("name", "username");
		param.put("rela", "=");
		param.put("value", "'"+jsonobject.get("username").toString()+"'");
		params.add(param);


		List<User> result_new;
		try {
			result_new = new UserAction().query(params);
			if(result_new.size()==0) {
				if(!jsonobject.get("username").toString().equals("")) {
					if(!jsonobject.get("password").toString().equals("")) {
						User user = new User();
						user.setUsername(jsonobject.get("username").toString());
						user.setPassword(jsonobject.get("password").toString());
						user.setTelephone("1234567");
						user.setEmail("1234567@gmail.com");
						user.setSex(0);
						new UserAction().add(user);
						register_sucess = true;
					}
				}

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


		return register_sucess;
	}


	public boolean validLogin(String username_input,String password_input) {

		boolean login_sucess = false ;
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("name", "username");
		param.put("rela", "=");
		param.put("value", "'"+username_input+"'");
		params.add(param);


		List<User> result_new;
		try {
			result_new = new UserAction().query(params);
			for(User temp:result_new){
				if(temp!=null) {
					if(temp.getPassword().equals(password_input)) {
						login_sucess=true;
					} 
				}

			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return login_sucess;
	}



	//	public static void main(String[] args) throws SQLException {
	//		List<User> result = new ArrayList<User>();
	//		result = new UserAction().query();
	//		for(User temp:result){
	//			System.out.println(temp.getId());
	//			System.out.println(temp.getUsername());  
	//		} 
	//		System.out.println("-------------------");
	//		User user = new UserAction().get(1);
	//		
	//		System.out.println(user.getUsername());
	//		System.out.println(user.getPassword());
	//		System.out.println(user.getTelephone());
	//		System.out.println(user.getEmail());
	//		System.out.println(user.getSex());
	//		
	//		System.out.println("------------");
	//		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
	//		Map<String,Object> param = new HashMap<String,Object>();
	//		param.put("name", "username");
	//		param.put("rela", "=");
	//		param.put("value", "'admin'");
	//		params.add(param);
	//		
	//		List<User> result_new =new UserAction().query(params);
	//		for(User temp:result_new){
	//			System.out.println(temp.getId());
	//			System.out.println(temp.getUsername());
	//			System.out.println(temp.getPassword());  
	//			System.out.println(temp.getTelephone());  
	//			System.out.println(temp.getEmail());
	//			System.out.println(temp.getSex());  
	//		} 
	//	}


}
