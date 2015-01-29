package es.coritel.codington.festival.services;

import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.daos.DAOManager;
import es.coritel.codington.festival.daos.EventDAO;
import es.coritel.codington.festival.daos.EventSignUpDAO;
import es.coritel.codington.festival.daos.SequencerDAO;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.exceptions.ServiceException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.interfaces.daos.ISequencerDAO;
import es.coritel.codington.festival.interfaces.services.IEventService;

public class EventService  implements IEventService{
	
	public EventService(){}

	/**
	 * SERVICE CLASS for displaying all events
	 * @param 
	 * @return list<Event> 
	 * @throws ServiceException
	 */
	@Override
	public List<Event> getAllEvents() throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager=null;
		List<Event> showEvents = new ArrayList<Event>();
		try{
			daoManager= new DAOManager();
			
			//Obtenemos un IEventDAO del DaoManager
			IEventDAO eventDAO=daoManager.getEventDAO();
			
			//Llamamos al dao que nos devuelve la lista de eventos 
			//Event event = new Event();
			//event.setEventId(event.getEventId());
			showEvents=eventDAO.showAllEvents();
			daoManager.closeOk();
			
		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return showEvents;
	}
	



	/**
	 * SERVICE CLASS for displaying all events
	 * @param eventName
	 * @return list<Event> 
	 * @throws ServiceException
	 */
	

	@Override
	public List<Event> getAllEvents(Event eventName) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager=null;
		List<Event> showEvents = new ArrayList<Event>();
		try{
			daoManager= new DAOManager();
			
			//Obtenemos un IEventDAO del DaoManager
			IEventDAO eventDAO=daoManager.getEventDAO();
			
			//Llamamos al dao que nos devuelve la lista de nombres de los eventos para los cuales
			//está registrado por eventName
			showEvents=eventDAO.showAllEvents(eventName);
			daoManager.closeOk();

			
		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		
		return showEvents;
	}

	/**
	 * SERVICE CLASS for searching event 
	 * @param event
	 * @return eventId
	 * @throws ServiceException
	 */
	
	@Override
	public Event getEvent(int eventId) throws ServiceException {
		// TODO Auto-generated method stub
		Event event = new Event();
		DAOManager daoManager=null;

		try{
			daoManager= new DAOManager();
			//Obtenemos un IEventDAO del DAOManager
			IEventDAO eventDAO=daoManager.getEventDAO();
			//Llamamos al dao que nos devuelve el evento
			event=eventDAO.getEvent(eventId);
			daoManager.closeOk();
		}catch (DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return event;
	}

	
	
	/**
	 * SERVICE CLASS for updating event details
	 * @param event
	 * @return status
	 * @throws ServiceException
	 */
	@Override
	public int updateEvent(Event event) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager=null;
		int status=0;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un IEvent del DaoManager
			IEventDAO eventDAO=daoManager.getEventDAO();
			
			//Llamamos al dao que actualiza la información del evento
			status=eventDAO.updateEvent(event);
			daoManager.closeOk();
			
		}catch(DAOException e){
			daoManager.closeError();
			status=-1;
		}
		return status;
	}

	
	/**
	 * SERVICE CLASS for delete event details
	 * @param enentId
	 * @return status
	 * @throws ServiceException
	 */
	@Override
	public int deleteEvent(int eventId) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager = null;
		int status=0;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un IEventDAO del DaoManager
			IEventDAO eventDAO=daoManager.getEventDAO();
			status=eventDAO.deleteEvent(eventId);
			daoManager.closeOk();
		}catch(DAOException e){
			daoManager.closeError();
			status=-1;
		}
		return status;
	}

	/**
	 * SERVICE CLASS for inserting new event
	 * @param event
	 * @return status
	 * @throws ServiceException
	 */
	
	@Override
	public int insertEvent(Event event) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager = null;
		int status=0;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un IEventDAO del DaoManager
			IEventDAO eventDAO = daoManager.getEventDAO();
			
			//Obtenemos el SequencerDAO
			ISequencerDAO sequencerDAO=daoManager.getSequencerDAO();
			
			//Obtenemos el siguiente id del evento
			int id=sequencerDAO.getNext(ISequencerDAO.CLASS_EVENT_NAME);
			
			//le asignamos el id obtenido
			event.setEventId(id);

			
			//Llamamos al dao que actualiza la información del visitante
			status=eventDAO.insertEvent(event);
			daoManager.closeOk();

		}catch(DAOException e){
			daoManager.closeError();
			status =-1;
		}
		return status;
	}
	
	/**
	 * SERVICE CLASS for unregister event
	 * @param visitor and event
	 * @return 
	 * @throws ServiceException
	 */

	@Override
	public void unregisterEvent(Visitor visitor, Event event) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager = null;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un EventDAO del DaoManager
			EventSignUp eventSignUp = new EventSignUp();
			
			eventSignUp.setIdEvent(event.getEventId());
			eventSignUp.setIdVisitor(visitor.getVisitorId());
			EventSignUpDAO evedao=daoManager.getIEventSignUpDAO();
			evedao.unregisterVisitorToEvent(eventSignUp);
			EventDAO edao=daoManager.getEventDAO();
			edao.updateSeatsEventInc(event);
			
			daoManager.closeOk();
			
		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}

		
	}

	
	@Override
	public void registerEvent(Visitor visitor, Event event) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager = null;
		try{
	        daoManager = new DAOManager();
 
			//Obtenemos un EventDAO del DaoManager
			EventSignUp eventSignUp = new EventSignUp();
			
			eventSignUp.setIdEvent(event.getEventId());
			eventSignUp.setIdVisitor(visitor.getVisitorId());
			
			EventSignUpDAO evedao =daoManager.getIEventSignUpDAO();

			if (!evedao.checkEventsofVisitor(eventSignUp) && event.getSeatsAEvent()>0){			
			
				SequencerDAO sdao=daoManager.getSequencerDAO();
				eventSignUp.setId(sdao.getNext(ISequencerDAO.CLASS_EVENT_SIGNUP_NAME));
			
				evedao.registerVisitorToEvent(eventSignUp);
				EventDAO edao=daoManager.getEventDAO();
				edao.updateSeatsEventDec(event);
			}else {
				if(evedao.checkEventsofVisitor(eventSignUp)){
					throw new ServiceException("User already registered for the EVENT ");
				}
				
				throw new ServiceException("No seats available ");
			}
			
			daoManager.closeOk();
			

		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		
	}

}



