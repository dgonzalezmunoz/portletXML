package es.coritel.codington.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.coritel.codington.festival.daos.EventDAOImplSql;
import es.coritel.codington.festival.domain.Event;

//Es un servlet controlado por el Spring MVC, sustituto por ejemplo de Struts
@Controller
public class EventController {

 // Aquí está la magia !! Con poner @autowired, spring inyecta automáticamente aquí nuestro bean con el servicio !!
 // No hay que preocuparse de inicializarlo ni gestionarlo ni nada parecido !!
 @Autowired
 private EventDAOImplSql ServicioEventDAOISql;
 
 @RequestMapping("EventDAOISql.do")
 public ModelAndView getEvents(HttpServletRequest request, HttpServletResponse response) throws IOException {
 List<Event> list=ServicioEventDAOISql.showAllEvents();
 
     
  ModelAndView mv= new ModelAndView();
  //ModelAndView mv= new ModelAndView("Vista");
  mv.addObject("list",list);
  mv.setViewName("Vista");
  
  return mv;
  
 }
 
 @RequestMapping("insert.do")
 public ModelAndView insertEvents (HttpServletRequest request, HttpServletResponse response) throws IOException{
	 
	 Event e=new Event();
	 e.setName(request.getParameter("eventname"));
	 e.setDescription(request.getParameter("eventdescription"));
	 e.setPlace(request.getParameter("places"));
	 e.setDuration(request.getParameter("duration"));
	 e.setEventType(request.getParameter("eventtype"));
	 
	 String avtic=request.getParameter("seatsavailable");
	 int acti=Integer.parseInt(avtic);
	 e.setSeatsAEvent(acti);
	 
	 ServicioEventDAOISql.insertEvent(e);
	 List<Event> list=ServicioEventDAOISql.showAllEvents();

	 ModelAndView mv= new ModelAndView();
	 mv.addObject("list",list);
	 mv.setViewName("Vista");
	 return mv;
 }
}