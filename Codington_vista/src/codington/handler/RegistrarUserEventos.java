package codington.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import codington.interfaces.HandleRequest;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.services.VisitorService;

public class RegistrarUserEventos implements HandleRequest {

	@Override
	public String requestHandler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		EventService es = new EventService();
		VisitorService vs=new VisitorService();
		
		Visitor visitor=(Visitor)session.getAttribute("visitante");
		Event event=new Event();
		
		try{
			int id=Integer.parseInt(request.getParameter("Evento"));
			//event.setEventId(id);
			event=es.getEvent(id);
			es.registerEvent(visitor, event);
			List<Event> listaEventos=vs.showRegisteredEvents(visitor);
			List<Event> eventosDisponible=es.getAllEvents();
			
			session.setAttribute("eventosRegistrados", listaEventos);
			session.setAttribute("eventos",eventosDisponible);
			
			
		}catch(Exception e){
			String error=e.getMessage();
			request.setAttribute("error", error);
			return "principal.jsp";
		
		}


		
		return "principal.jsp";
	}

}
