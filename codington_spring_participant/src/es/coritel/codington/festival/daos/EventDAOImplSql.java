package es.coritel.codington.festival.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.map.EventMapper;
import es.coritel.codington.festival.utils.FERSDbQuery;


public class EventDAOImplSql implements IEventDAO
{
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource (DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate (dataSource);
	}
	
	public List<Event> showAllEvents() throws DAOException{
		List<Event> events= jdbcTemplate.query(FERSDbQuery.getAllEvents(), new EventMapper());	
		return events;
	}
	
	public void insertEvent(Event event) throws DAOException{
		jdbcTemplate.update(FERSDbQuery.getInsertEvent(),event.getEventId()
														,event.getName()
														,event.getDescription()
														,event.getPlace()
														,event.getDuration()
														,event.getEventType()
														,event.getSeatsAEvent());

	}

}
