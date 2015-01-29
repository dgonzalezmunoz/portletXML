package com.web.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.handlers.Handler;
import com.web.handlers.LoginUser;
import com.web.handlers.RegisterUser;



public class ControllerServlet extends HttpServlet {
    
	HashMap<String, Handler> handlers;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	    handlers=new HashMap<String, Handler>();
		handlers.put("/registerUser.do",new RegisterUser());
		handlers.put("/loginUser.do",new LoginUser());
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		Handler handler=(Handler)handlers.get(req.getServletPath());
		String URL=handler.processor(req, resp);
		req.getRequestDispatcher(URL).forward(req, resp);
		
	}

	
	

}
