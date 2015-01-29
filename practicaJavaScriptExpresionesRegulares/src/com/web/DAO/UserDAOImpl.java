package com.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.DAOinterfaces.UserDAO;
import com.web.domain.User;
import com.web.exceptions.DAOException;
import com.web.utils.FersDataConnection;
import com.web.utils.FersDbQuery;

public class UserDAOImpl implements UserDAO {
	
	Connection conn;
	PreparedStatement st;

	public UserDAOImpl(Connection conn) {
		this.conn=conn;
	}
      
	@Override
	public void insertUser(User user) {
	
		
		try{
		st=conn.prepareStatement(FersDbQuery.getinsertuser());//Preparar la sentencia SQL
		
		st.setString(1, user.getUserId());
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
	public String  selectPassword(User user) {
	
		try{	
			st=conn.prepareStatement(FersDbQuery.getselectPassword());
			st.setString(1,user.getUserId());
			ResultSet rtpass=st.executeQuery();
			String pass;
			
			if(rtpass.next())
			{
			     pass = rtpass.getString(1);
			     rtpass.close();
			     FersDataConnection.closeConnection();
			     return pass;
			}
			else{
				pass="NoUser";
				rtpass.close();
				FersDataConnection.closeConnection();
				return pass;
			}
			
	    }
		catch(Exception e)
		{
			throw new DAOException(e.getMessage());
		}
		
	}
	

}
