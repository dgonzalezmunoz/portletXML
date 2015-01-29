package com.web.utils;

public class FersDbQuery {
	
	private static String insertuser="INSERT INTO user"
			                   + "(ID_USER, PASSWORD, NAME, "
			                   + "LASTNAME, TELEPHONE, CITY) "
			                   + "VALUES (?, ?, ?, ?, ?, ?);";
	private static String selectPassword="SELECT PASSWORD FROM user WHERE ID_USER=?;";

	public FersDbQuery() {
		// TODO Auto-generated constructor stub
	}
	public  static String getinsertuser(){
		
		return insertuser;
	}
	public static String getselectPassword(){
		
		return selectPassword;
	}
	
}
