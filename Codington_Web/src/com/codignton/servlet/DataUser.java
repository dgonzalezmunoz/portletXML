package com.codignton.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.VisitorService;

/**
 * Servlet implementation class DataUser
 */
@WebServlet("/dataUser")
public class DataUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataUser() {
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
		
		PrintWriter salida= response.getWriter();
		response.setContentType("text/html");
		
		Visitor v= new Visitor();
		v.setUserName(request.getParameter("txtNombre"));
		VisitorService vs= new VisitorService();
		v=vs.searchVisitor(v);
		salida.println("<h1> Usuario "+v.getUserName()+"</h1><br/>" );
		salida.println("<h1> Nombre del usuario "+v.getFirstName()+"</h1><br/>" );
		salida.println("<h1> Last Name del usuario "+v.getLastName()+"</h1><br/>" );
		salida.println("<h1> DNI del usuario "+v.getDni()+"</h1><br/>" );
		salida.println("<h1> Email del usuario "+v.getEmail()+"</h1><br/>" );
		salida.println("<h1> Phone Number del  usuario "+v.getPhoneNumber()+"</h1><br/>" );
		salida.println("<h1> Address del usuario "+v.getAddress()+"</h1><br/>" );
		salida.println("<h1> Password del usuario "+v.getPassword()+"</h1><br/>" );
	}

}
