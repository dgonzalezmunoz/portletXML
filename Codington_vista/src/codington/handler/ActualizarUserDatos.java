package codington.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codington.interfaces.HandleRequest;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.VisitorService;

public class ActualizarUserDatos implements HandleRequest {

	@Override
	public String requestHandler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		VisitorService vs = new VisitorService();
		Visitor visitor=(Visitor)session.getAttribute("visitante");
		
		String pwd=request.getParameter("pwd");
		String cpwd=request.getParameter("cpwd");
		
		if(pwd.equals(cpwd)){
			visitor.setPassword(pwd);
			vs.changePassword(visitor);
			String userName=(request.getParameter("user"));
			String firstName=request.getParameter("firstname");
			String lastName=request.getParameter("lastname");
			String email=request.getParameter("email");
			String phoneNumber=request.getParameter("phone");
			String address=request.getParameter("address");
			visitor.setFirstName(firstName);
			visitor.setLastName(lastName);
			visitor.setUserName(userName);
			visitor.setEmail(email);
			visitor.setPhoneNumber(phoneNumber);
			visitor.setAddress(address);
			
			vs.updateVisitorDetails(visitor);	
		}
		
		return "index.jsp";
	
	}

}
