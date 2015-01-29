package es.coritel.codington.festival.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class EventDAO implements IEventDAO {
	
	private Connection connection=null;
	private PreparedStatement st=null;
	private ResultSet rs;
	private FERSDbQuery query = new FERSDbQuery();
	
	//private FERSDataConnection connection;
	
	public EventDAO(){}
	
	public EventDAO (Connection conn){
		this.connection=conn;
	}
	

	@Override
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
	public List<Event> showAllEvents(Event eventName) throws DAOException {
		// TODO Auto-generated method stub
		List<Event> eventList = new ArrayList<Event>();
		try{
			st=connection.prepareStatement(query.getSearchByEventName());
			st.setString(1, "%"+ eventName.getName()+ "%");	
			//st.setString(1,eventName.getName());
			rs = st.executeQuery();
				
			while(rs.next()){
				Event event= new Event();
				eventName.setEventId(rs.getInt("id"));
			    eventName.setName(rs.getString("name"));
			    eventName.setDescription(rs.getString("description"));
			    eventName.setPlace(rs.getString("places"));
			    eventName.setDuration(rs.getString("duration"));
			    eventName.setEventType(rs.getString("event_type"));
			    eventName.setSeatsAEvent(rs.getInt("seats_available"));
			    
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
	public Event getEvent(int eventId) throws DAOException {
		// TODO Auto-generated method stub
		Event event = new Event();
		try{
			st=connection.prepareStatement(query.getGetEvent());
			st.setInt(1, eventId);
			//st.setInt(1,event.getEventId());
			rs=st.executeQuery();
			
			while(rs.next()){
				event.setEventId(rs.getInt("id"));
			    event.setName(rs.getString("name"));
			    event.setDescription(rs.getString("description"));
			    event.setPlace(rs.getString("places"));
			    event.setDuration(rs.getString("duration"));
			    event.setEventType(rs.getString("event_type"));
			    event.setSeatsAEvent(rs.getInt("seats_available"));
				
			}
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeResulSet(rs);
			FERSDataConnection.closeStatement(st);
		}
		return event;
	}

	@Override
	public int updateEvent(Event updateEvent) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getUpdateEvent());
			
			st.setString(1, updateEvent.getName());
			st.setString(2, updateEvent.getDescription());
			st.setString(3, updateEvent.getPlace());
			st.setString(4, updateEvent.getDuration());
			st.setString(5, updateEvent.getEventType());
			st.setInt(6, updateEvent.getSeatsAEvent());
			st.setInt(7, updateEvent.getEventId());
			
			status=st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return status;
	}


	@Override
	public int insertEvent(Event insertEvent) throws DAOException {
		// TODO Auto-generated method stub
		int status=-1;
		try{
			st=connection.prepareStatement(query.getInsertEvent());
			
			st.setInt(1,insertEvent.getEventId());
			st.setString(2, insertEvent.getName());
			st.setString(3, insertEvent.getDescription());
			st.setString(4, insertEvent.getPlace());
			st.setString(5, insertEvent.getDuration());
			st.setString(6, insertEvent.getEventType());
			st.setInt(7, insertEvent.getSeatsAEvent());
			
			status=st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return status;
	}

	@Override
	public int deleteEvent(int eventId) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			//Event event= new Event();
			//event.setEventId(eventId);
			st=connection.prepareStatement(query.getDeleteEvent());
			st.setInt(1, eventId);
			//st.setInt(1,event.getEventId());
			
			status=st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return status;
	}

	@Override
	public int updateSeatsEventDec(Event event) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getUpdateSeatsEventDec());
			st.setInt(1, event.getEventId());
			status= st.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return status;
	}

	@Override
	public int updateSeatsEventInc(Event event) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getUpdateSeatsEventInc());
			st.setInt(1, event.getEventId());
			status= st.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return status;
	
	}

}
