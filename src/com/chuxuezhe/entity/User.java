package com.chuxuezhe.entity;

public class User {
	
    private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	private String username;
	private String password;
	private String telephone;
	private String email;
	private int sex;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}

	public User() {
		
	}

}
