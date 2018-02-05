package com.chuxuezhe.jsoner;


import org.json.simple.JSONObject;

public class WriteJsoner {
	JSONObject obj = new JSONObject();
	
	@SuppressWarnings("unchecked")
	public JSONObject writeRegReqJson(String[] str) {
		obj.put("Type", str[0]);
		obj.put("func", str[1]);
		obj.put("username", str[2]);
		obj.put("password", str[3]);
		obj.put("telephone", str[4]);
		obj.put("email", str[5]);
		obj.put("sex", Integer.getInteger(str[6]));
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject writeLoginReqJson(String[] str) {
		obj.put("Type", str[0]);
		obj.put("func", str[1]);
		obj.put("username", str[2]);
		obj.put("password", str[3]);
		return obj;
	} 
	
	@SuppressWarnings("unchecked")
	public JSONObject writeRegResJson(String[] str) {
		obj.put("Type", str[0]);
		obj.put("func", str[1]);
		obj.put("result", str[2]);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject writeLoginResJson(String[] str) {
		obj.put("Type", str[0]);
		obj.put("func", str[1]);
		obj.put("result", str[2]);
		return obj;
	} 
	
}
