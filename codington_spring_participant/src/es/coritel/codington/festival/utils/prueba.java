package es.coritel.codington.festival.utils;





import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventServiceImpl;



public class prueba
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ApplicationContext bean = new ClassPathXmlApplicationContext("application-context.xml");
		EventServiceImpl servicio = bean.getBean("servicio", EventServiceImpl.class);
		
		
		
		List<Event> eventList = servicio.getAllEvents();
		
		for(int i=0; i<eventList.size();i++){
			
			System.out.println(eventList.get(i).getName()+ "Descripcion "+eventList.get(i).getDescription()+
					"Place "+ eventList.get(i).getPlace()+ "Duration "+eventList.get(i).getDuration()+
					"Event Type "+eventList.get(i).getEventType()+"Seats "+ eventList.get(i).getSeatsAEvent());
		}
				

	}

}
