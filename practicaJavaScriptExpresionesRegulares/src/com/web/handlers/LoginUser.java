package com.web.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.User;
import com.web.services.UserService;

public class LoginUser implements Handler {

	public LoginUser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String processor(HttpServletRequest request,
			HttpServletResponse response) {
       try{
    	   String  userId=request.getParameter("user");
    	   String password= request.getParameter("password");
    	   User user=new User();
    	   user.setUserId(userId);
    	   user.setPassword(password);
    	   boolean validation=new UserService().loginUser(user);
    	   request.setAttribute("validation", validation);
    	   if(validation){
    			return "interfaz.jsp";
    		}
    	   else{
    		   return "index.jsp";
    	   }
       }catch(Exception e)
       {
    	   return "index.jsp";
       }
	
	}

}
