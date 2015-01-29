package com.web.DAO;

import java.sql.Connection;

import com.web.utils.FersDataConnection;

public class DAOManager {
	
	Connection conn=null;

	public DAOManager() {
		
		 this.conn=FersDataConnection.getConnection();
		
	}
	public  UserDAOImpl getUserDAOImpl(){
	 return new UserDAOImpl(conn);
	}

}
