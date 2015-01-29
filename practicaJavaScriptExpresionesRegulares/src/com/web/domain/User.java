package com.web.domain;

public class User {

	private 	String  userId;
	
	private String password;
	
	private String name;
	
	private String lastName;
	
	private String telephone;
	
	private String city;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String pass, String nam, String lastnam, String telephone, String city) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.name=nam;
		this.password=pass;
		this.lastName=lastnam;
		this.telephone=telephone;
		this.city=city;
	}
	
	
	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getTelephone() {
		return telephone;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	
	

}
