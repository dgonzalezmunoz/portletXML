package es.coritel.codington.festival.services;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import es.coritel.codington.festival.daos.EventDAOImpl1;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.ServiceException;
import es.coritel.codington.festival.interfaces.services.EventFacade;

/**
 * SERVICE class for the EVENT objects with DAO layer
 */

public class EventServiceImpl implements EventFacade
{

	EventDAOImpl1 eventDAO;

	/**
	 * Inyección de la dependencia IEventDAO
	 * 
	 * @param eventDAO
	 */
	
	public void setEventDAO(EventDAOImpl1 eventDAO)
	{
		this.eventDAO = eventDAO;
	}
	
	public void setDatasource(DataSource x){
		eventDAO.setEventDAOImpl1(x);

	}


	/**
	 * SERVICE CLASS for displaying all events from DAO
	 * 
	 * @return list<Event> all events
	 * @throws ServiceException
	 */
	public List<Event> getAllEvents()
	{

		List<Event> showEvents = new ArrayList<Event>();

		try
		{
			// Llamamos al método que devuelve todas los eventos disponibles
			showEvents = eventDAO.showAllEvents();

		} catch (DataAccessException e)
		{

			// Capturamos la DAOException y lanzamos una ServiceException
			throw new ServiceException(e.getMessage());
		}
		return showEvents;
	}

	@Override
	public void insertEvent(Event event) throws ServiceException
	{


	}
}
