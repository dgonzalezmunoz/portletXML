package com.web.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAO.DAOManager;
import com.web.domain.User;
import com.web.services.UserService;

public class RegisterUser implements Handler{

	public RegisterUser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String processor(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter("user");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String lastname=request.getParameter("lastname");
		String telephone=request.getParameter("telephone");
		String city=request.getParameter("city");
		User user=new User(userid,password,name,lastname,telephone,city);
		new UserService().registerUser(user);
		return "index.jsp";
	}

}
