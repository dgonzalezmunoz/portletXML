package es.coritel.codington.festival.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class EventDAOImpl1 implements IEventDAO
{
	List<Event> eventos;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	
	private Connection connection=null;
	private PreparedStatement st=null;
	private ResultSet rs;
	private FERSDbQuery query = new FERSDbQuery();
	

	
//	public EventDAOImpl1 (){
//		super();
//		this.connection=FERSDataConnection.getConnection();
//	}
	
	public void setEventDAOImpl1(DataSource x){
		this.jdbcTemplate= new JdbcTemplate(x);
	}
	
	public void setEventos(List<Event> eventos)
	{
		this.eventos = eventos;
	}

	@Override
//	public List<Event> showAllEvents() throws DAOException
//	{
//
//		return eventos;
//	}
	public List<Event> showAllEvents() throws DAOException {
		// TODO Auto-generated method stub
		List<Event> eventList = new ArrayList<Event>();
		try{
			st=connection.prepareStatement(query.getAllEvents());
			rs= st.executeQuery();

			while(rs.next()){
				Event event=new Event();
				
				event.setEventId(rs.getInt("id"));
			    event.setName(rs.getString("name"));
			    event.setDescription(rs.getString("description"));
			    event.setPlace(rs.getString("places"));
			    event.setDuration(rs.getString("duration"));
			    event.setEventType(rs.getString("event_type"));
			    event.setSeatsAEvent(rs.getInt("seats_available"));
			    
			    eventList.add(event);
			    
			}
	
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeResulSet(rs);
			FERSDataConnection.closeStatement(st);
		}
		
		return eventList;
		
	}

	@Override
	public void insertEvent(Event event) throws DAOException
	{
		// TODO Auto-generated method stub
		jdbcTemplate.update(FERSDbQuery.getInsertEvent(),
		event.getEventId());
	}

}
