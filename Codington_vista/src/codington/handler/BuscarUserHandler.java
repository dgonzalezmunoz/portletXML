package codington.handler;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codington.interfaces.HandleRequest;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.services.VisitorService;

public class BuscarUserHandler implements HandleRequest {

	@Override
	public String requestHandler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VisitorService vs = new VisitorService();
		Visitor visitor = new Visitor();
		EventService es= new EventService();
		
		visitor.setUserName(request.getParameter("user"));
		visitor.setPassword(request.getParameter("pwd"));
		
		Visitor visitorFound=vs.searchVisitor(visitor);
		List<Event> listaEventos= es.getAllEvents();
		
		
		HttpSession session=request.getSession();
		if((visitorFound!=null) && (visitorFound.getPassword().equals(request.getParameter("pwd")))){
			List<Event> eventregistered = vs.showRegisteredEvents(visitorFound);
		
			session.setAttribute("visitante", visitorFound);
			session.setAttribute("eventos",listaEventos );
			session.setAttribute("eventosRegistrados", eventregistered);
	
			return "principal.jsp";
		}
		else{
			
			session.setAttribute("error","error");
			return "index.jsp";
		}
	}

}
