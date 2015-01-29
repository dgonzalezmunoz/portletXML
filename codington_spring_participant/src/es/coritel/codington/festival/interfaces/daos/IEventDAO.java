package es.coritel.codington.festival.interfaces.daos;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;

public interface IEventDAO {
	
	

	/**
	 * DAO for displaying all the FESTIVALEVENTS in EVENT TABLE
	 * @return collection of all Events
	 * @throws DAOException
	 */
	public List<Event> showAllEvents() throws DAOException ;
	/**
	 * DAO for insert a FESTIVALEVENT in EVENT TABLE
	 * @return collection of all Events
	 * @throws DAOException
	 */
	public void insertEvent(Event event) throws DAOException ;


	

	
	


	
		

	
	

}
