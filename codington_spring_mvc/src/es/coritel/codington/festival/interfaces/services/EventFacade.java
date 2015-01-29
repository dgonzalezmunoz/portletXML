package es.coritel.codington.festival.interfaces.services;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.ServiceException;

/**
 * EVENTFACADE INTERFACE for defining abstract for EVENTSERVICEIMPLEMENTATION
 */
public interface EventFacade
{

	/**
	 * Service for displaying all the FESTIVALEVENTS
	 * 
	 * @return collection of all Events
	 * @throws ServiceException
	 */
	public List<Event> getAllEvents() throws ServiceException;

	void insertEvent(Event event) throws ServiceException;

}
