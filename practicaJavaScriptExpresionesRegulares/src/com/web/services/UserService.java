package com.web.services;

import com.web.DAO.DAOManager;
import com.web.domain.User;

public class UserService {

	public UserService() {}
		// TODO Auto-generated constructor stub
	
	public void registerUser(User user){
		DAOManager dao=new DAOManager();
		dao.getUserDAOImpl().insertUser(user);
	}
	
	public 	boolean loginUser(User user){
		DAOManager dao=new DAOManager();
	    String pass=dao.getUserDAOImpl().selectPassword(user);
	    boolean response;
	    if(!(user.getPassword().equals(pass)) || pass.equals("NoUser")){
	    	
	    	 response=false; 
	    }
	    else{
	         response=true;
	    	
	    }
	    return response;
	}

}
