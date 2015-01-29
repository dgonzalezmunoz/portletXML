package com.web.utils;

import com.web.exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FersDataConnection {
	private static Connection  conn;

	public FersDataConnection() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() throws DAOException {
		try {
    		String url = "jdbc:mysql://localhost/mydb";
    		String user = "root";
    		String pass = "Gargamel71";
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection(url, user, pass);
    		System.out.println("Connection successfully established! \n");
    		conn.setAutoCommit(true);
    		//conn.close();

    		}catch(Exception e){
    			//System.out.println(e.getMessage());
    			throw new DAOException(e.getMessage());
    				
    		}	
    	return conn;
	}
	public static void closeConnection() throws DAOException {
		try{
		
			conn.close();	
			
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
	}
	
}
