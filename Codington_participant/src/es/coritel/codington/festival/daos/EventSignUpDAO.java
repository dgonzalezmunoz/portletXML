package es.coritel.codington.festival.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventSignUpDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class EventSignUpDAO implements IEventSignUpDAO {
	
	private Connection connection=null;
	private PreparedStatement st=null;
	private ResultSet rs;
	private static FERSDbQuery query = new FERSDbQuery();
	
	int res=0;
	
	public EventSignUpDAO(){}
	
	public EventSignUpDAO(Connection conn){
		this.connection=conn;
	}
	

	@Override
	public boolean checkEventsofVisitor(EventSignUp eventSignUp) throws DAOException {
		// TODO Auto-generated method stub
		boolean b;
		try{
			st=connection.prepareStatement(FERSDbQuery.getCheckEvent());
			st.setInt(1, eventSignUp.getIdVisitor());
			st.setInt(2, eventSignUp.getIdEvent());
			rs=st.executeQuery();
			//b=rs.next();
			if(rs.next()){
				return true;
			}

		}catch (SQLException e){
			//b=false;
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeResulSet(rs);
			FERSDataConnection.closeStatement(st);
		}
		return false;
		//return b;
	}
	

	@Override
	public void unregisterVisitorToEvent(EventSignUp eventSignUp) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getUnRegisterVisitorToEvent());
			
			st.setInt(1, eventSignUp.getIdVisitor());
			st.setInt(2, eventSignUp.getIdEvent());
			
			status =st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}

	}

	@Override

	public void registerVisitorToEvent(EventSignUp eventSignUp) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getRegisterVisitorToEvent());
			
			st.setInt(1, eventSignUp.getId());
			st.setInt(2, eventSignUp.getIdVisitor());
			st.setInt(3, eventSignUp.getIdEvent());
			
			status=st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}

	}

	@Override
	public int deleteEventSignUp(int eventId) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			st=connection.prepareStatement(query.getDeleteEventSessionSignup());
			st.setInt(1, eventId);
			
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
	public List<Event> registeredEvents(EventSignUp eventSignUp) throws DAOException {
		// TODO Auto-generated method stub
		List<Event> eventList = new ArrayList<Event>();
		Event event;
		try{
			st=connection.prepareStatement(query.getEventsRegistered());
			st.setInt(1, eventSignUp.getIdVisitor());
			rs=st.executeQuery();
			
			while(rs.next()){
				event= new Event();
				event.setEventId(rs.getInt(1));
				event.setName(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setPlace(rs.getString(4));
				event.setDuration(rs.getString(5));
				event.setEventType(rs.getString(6));
				event.setSeatsAEvent(rs.getInt(7));
				eventList.add(event);
			}
			
		}catch(SQLException e){
			eventList=null;
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeResulSet(rs);
			FERSDataConnection.closeStatement(st);
		}
		return eventList;
	}
	
}
