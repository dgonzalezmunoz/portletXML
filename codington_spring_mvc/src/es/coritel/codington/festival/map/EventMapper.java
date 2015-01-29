package es.coritel.codington.festival.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.coritel.codington.festival.domain.Event;

public class EventMapper implements RowMapper<Event>
{
	public Event mapRow(ResultSet resultset, int x) throws SQLException{
		Event e= new Event();
		e.setEventId(resultset.getInt(1));
		e.setName(resultset.getString(2));
		e.setDescription(resultset.getString(3));
		e.setPlace(resultset.getString(4));
		e.setDuration(resultset.getString(5));
		e.setEventType(resultset.getString(6));
		e.setSeatsAEvent(resultset.getInt(7));
		
		return e;
	}
}
