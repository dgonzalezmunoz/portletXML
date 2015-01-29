package es.coritel.codington.festival.utils;

/**
 * Helper class for externalization of queries
 */
public class FERSDbQuery {
	
	// SQL queries for EVENTDAO
	private String allEvents = "SELECT id, name, description, places, duration, event_type, seats_available FROM events";
	private String searchByEventName = "SELECT id, name, description, places, duration, event_type, seats_available FROM events WHERE name LIKE ?";	
	private String updateSeatsEventDec = "UPDATE events SET seats_available = seats_available - 1  WHERE id = ?";
	private String updateSeatsEventInc = "UPDATE events SET seats_available = seats_available + 1  WHERE id = ?";	
	private String getEvent = "SELECT id, name, description, places, duration, event_type, seats_available FROM events WHERE id = ?";
	private String updateEvent = "UPDATE events SET name=?, description=?, places=?, duration=?, event_type=?, seats_available = ? WHERE id=?";	
	private String insertEvent = "INSERT INTO events(id, name, description, places, duration, event_type,seats_available) VALUES(?,?,?,?,?,?,?)";
	private String deleteEvent = "DELETE FROM events WHERE id=?";


	// SQL queries for VISITORDAO
	private String insertQuery = "INSERT INTO visitors(username,password,firstname,lastname,email,phone_number,address,dni) VALUES(?,?,?,?,?,?,?,?)";
	private String searchQuery = "SELECT * FROM visitors WHERE username=?";
	
	//SQL queries for EVENTSIGNUPDAO
	private String registerQuery = "INSERT INTO events_signup(id,visitor_id,event_id) VALUES(?,?,?)";
	private String deleteEventSessionSignup = "DELETE FROM evenst_signup WHERE event_id = ?";
	private String checkEvent = "SELECT count(*) AS event_count FROM events_signup WHERE visitor_id=? AND event_id=?";
	

	private String statusQuery = "SELECT DISTINCT E1.id, E1.name, E1.description, E1.places, E1.duration, E1.event_type, E1.seats_available  FROM events E1, events_signup E2  WHERE E1.id= E2.event_id  AND E2.visitor_id=?";
	private String updateQuery = "UPDATE visitors SET firstname=?, lastname=?, username=?, dni=?,email=?, phone_number=?, address=? WHERE id=?";
	private String deleteEventQuery = "DELETE FROM events_signup WHERE event_id = ? AND visitor_id = ?";
	private String changePWDQuery = "UPDATE visitors SET password=? WHERE id=?";
	private String sequencerActual ="SELECT value FROM sequencer WHERE name=? ";
	private String actualizaSequencer ="UPDATE sequencer SET value=value+1 WHERE name=? ";

	/**
	 * Establece el valor de la query que obtiene todos eventos de la base de datos
	 * 
	 * @param getAllEvents
	 */
	public void setAllEvents(String allEvents) {
		this.allEvents = allEvents;
	}
	/**
	 * Devuelve la query que obtiene todos eventos de la base de datos
	 * 
	 * @return allEvents
	 */
	public String getAllEvents() {
		return allEvents;
	}
	
	/**
	 *  Devuelve la query que obtiene un evento con un nombre determinado 
	 */
	public String getSearchByEventName() {
		return searchByEventName;
	}
	public void setSearchByEventName(String searchByEventName) {
		this.searchByEventName = searchByEventName;
	}
	
	public String getUpdateSeatsEventDec() {
		return updateSeatsEventDec;
	}
	public void setUpdateSeatsEventDec(String updateSeatsEventDec) {
		this.updateSeatsEventDec = updateSeatsEventDec;
	}
	public String getUpdateSeatsEventInc() {
		return updateSeatsEventInc;
	}
	public void setUpdateSeatsEventInc(String updateSeatsEventInc) {
		this.updateSeatsEventInc = updateSeatsEventInc;
	}
	public String getCheckEvent() {
		return checkEvent;
	}
	public void setCheckEvent(String checkEvent) {
		this.checkEvent = checkEvent;
	}
	public String getGetEvent() {
		return getEvent;
	}
	public void setGetEvent(String getEvent) {
		this.getEvent = getEvent;
	}
	public String getUpdateEvent() {
		return updateEvent;
	}
	public void setUpdateTEvent(String updateEvent) {
		this.updateEvent = updateEvent;
	}
	public String getInsertEvent() {
		return insertEvent;
	}
	public void setInsertEvent(String insertEvent) {
		this.insertEvent = insertEvent;
	}
	public String getDeleteEvent() {
		return deleteEvent;
	}
	public void setDeleteEvent(String deleteEvent) {
		this.deleteEvent = deleteEvent;
	}
	public String getDeleteEventSessionSignup() {
		return deleteEventSessionSignup;
	}
	public void setDeleteEventSessionSignup(String deleteEventSessionSignup) {
		this.deleteEventSessionSignup = deleteEventSessionSignup;
	}
	public String getInsertQuery() {
		return insertQuery;
	}
	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	public String getRegisterQuery() {
		return registerQuery;
	}
	public void setRegisterQuery(String registerQuery) {
		this.registerQuery = registerQuery;
	}
	public String getStatusQuery() {
		return statusQuery;
	}
	public void setStatusQuery(String statusQuery) {
		this.statusQuery = statusQuery;
	}
	public String getUpdateQuery() {
		return updateQuery;
	}
	public void setUpdateQuery(String updateQuery) {
		this.updateQuery = updateQuery;
	}
	public String getDeleteEventQuery() {
		return deleteEventQuery;
	}
	public void setDeleteEventQuery(String deleteEventQuery) {
		this.deleteEventQuery = deleteEventQuery;
	}
	public String getChangePWDQuery() {
		return changePWDQuery;
	}
	public void setChangePWDQuery(String changePWDQuery) {
		this.changePWDQuery = changePWDQuery;
	}
	public String getSequencerActual() {
		return sequencerActual ;
	}

	public String getActualizaSequencer() {
		return actualizaSequencer;
	}
	
	

	
	

}
