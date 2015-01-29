package es.coritel.codington.festival.utils;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.coritel.codington.festival.daos.EventDAOImplSql;
import es.coritel.codington.festival.domain.Event;



public class pruebaBeanFactory
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ApplicationContext bean = new ClassPathXmlApplicationContext("application-context.xml");
		EventDAOImplSql servicio = bean.getBean("eventDao2", EventDAOImplSql.class);
		
		DataSource ds= (DataSource) bean.getBean("dataSource");
		
		servicio.setDataSource(ds);
		
//		System.out.println(servicio.getAllEvents());
		Event e=new Event();
		e.setEventId(4);
		e.setName("Concert");
		e.setDescription("descripcion");
		e.setPlace("place4");
		e.setDuration("duration4");
		e.setEventType("eventType");
		e.setSeatsAEvent(15);
		servicio.insertEvent(e);
		
		
		List<Event> eventList = servicio.showAllEvents();
		for(int i=0; i<eventList.size(); i++){
			System.out.println(eventList.get(i).getName());
		}
		
		
		
		
//		
//		for(int i=0; i<eventList.size();i++){
//			
//			System.out.println(eventList.get(i).getName()+ "Descripcion "+eventList.get(i).getDescription()+
//					"Place "+ eventList.get(i).getPlace()+ "Duration "+eventList.get(i).getDuration()+
//					"Event Type "+eventList.get(i).getEventType()+"Seats "+ eventList.get(i).getSeatsAEvent());
//		}
				

	}

}
