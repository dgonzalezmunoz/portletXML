package com.codignton.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.VisitorService;

//import es.coritel.codington.festival.domain.Visitor;
//import es.coritel.codington.festival.services.VisitorService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		
		VisitorService vs= new VisitorService();
		Visitor v= new Visitor();
		Visitor v2= null;
		try{
			v.setUserName(request.getParameter("txtNombre"));
			v.setPassword(request.getParameter("txtPass"));
			response.setContentType("text/html");
			v2 =new Visitor(vs.searchVisitor(v));
			
			if(v2.getUserName().equals(v.getUserName()) && v2.getPassword().equals(v.getPassword())){
				RequestDispatcher dispatcher= request.getRequestDispatcher("/dataUser");
				if (dispatcher != null){
					dispatcher.forward(request, response);
				}
			}else {
				RequestDispatcher dispatcher= request.getRequestDispatcher("/noExist");
				if (dispatcher != null){
					dispatcher.forward(request, response);
				}
			}
		}catch (Exception e){
			RequestDispatcher dispatcher= request.getRequestDispatcher("/noExist");
			if (dispatcher != null){
				dispatcher.forward(request, response);
			}
		}

		}
		



}

