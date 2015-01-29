package com.web.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.utils.*;
import com.web.domain.User;
import com.web.exceptions.DAOException;

public class Main {
     static PreparedStatement st=null;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connection conn=FersDataConnection.getConnection();
		try{
		st=conn.prepareStatement(FersDbQuery.getinsertuser());
		User user=new User(23,"a","b","c","d","e");
		st.setInt(1, user.getUserId());
		st.setString(2, user.getPassword());
		st.setString(3, user.getName());
		st.setString(4, user.getLastName());
		st.setString(5, user.getTelephone());
		st.setString(6, user.getCity());
		st.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException(e.getMessage());
		}
		FersDataConnection.closeConnection();

	}

}
