package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.daos.DAOManager;
import es.coritel.codington.festival.daos.VisitorDAO;

//public class proves  extends People{
//	public static void main (String args[]){
//		People p=new People();
//		p.setDni("53.294.894-F");
//		//System.out.println(p.getFirstName());
//	}
//
//}

//public class proves{
//	public static void main(String args[]){
//		Event e= new Event();
//		EventDAO ed= new EventDAO();
//		
//		e.setEventId(3);
//		e.setName("as");
//		e.setDescription("ddd");
//		e.setPlace("dd");
//		e.setDuration("eee");
//		e.setEventType("ddd");
//		e.setSeatsAEvent(4);
//		
//		ed.showAllEvents(e);
//		
//	}
//}


public class proves{
	
	public static void main(String args[]){
	DAOManager dao= new DAOManager();
	Visitor v = new Visitor();
	VisitorDAO vd= dao.getVisitorDAO();
	
	v.setVisitorId(5);
	v.setUserName("marieta");
	v.setPassword("basquet");
	v.setFirstName("Maria");
	v.setLastName("Perez");
	v.setEmail("maria@gmail.com");
	v.setPhoneNumber("937777777");
	v.setAddress("c major");
	v.setDni("53.294.894-F");
	

	vd.insertData(v);
    }
}


