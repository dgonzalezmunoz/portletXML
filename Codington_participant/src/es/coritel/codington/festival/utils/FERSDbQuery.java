package es.coritel.codington.festival.utils;

/**
 * Helper class for externalization of queries
 */
public class FERSDbQuery {
	
	// SQL queries for EVENTDAO
	private static String allEvents="SELECT id, name, description, places, duration, event_type, seats_available FROM events"; //Obtiene todos los eventos de la tabla events
	
	private static String searchByEventName="SELECT id, name, description, places, duration, event_type, seats_available FROM events WHERE name LIKE ?"; //Obtiene un evento buscando por su nombre (búsqueda parcial)
	
	private static String updateSeatsEventDec="UPDATE events SET seats_available = seats_available - 1  WHERE id = ?"; //Decrementa el número de asientos disponibles para un evento dado
	
	private static String updateSeatsEventInc="UPDATE events SET seats_available = seats_available + 1  WHERE id = ?";	//Incrementa el número de asientos disponibles para un evento dado
	
	private static String getEvent="SELECT id, name, description, places, duration, event_type, seats_available FROM events WHERE id = ?"; //Obtiene un evento por su id
	
	private static String updateEvent= "UPDATE events SET name=?, description=?, places=?, duration=?, event_type=?, seats_available = ? WHERE id=?"; //actualiza un evento
	
	private static String insertEvent="INSERT INTO events(id, name, description, places, duration, event_type,seats_available) VALUES(?,?,?,?,?,?,?)"; //inserta un evento
	
	private static String deleteEvent="DELETE FROM events WHERE id=?"; //borra un evento 


	// SQL queries for VISITORDAO
	private static String insertVisitor="INSERT INTO visitors (id, username,password,firstname,lastname,email,phone_number,address,dni) VALUES(?,?,?,?,?,?,?,?,?)";
			//"INSERT INTO visitors  VALUES(?,?,?,?,?,?,?,?,?,?)"; //Inserta un visitante
	
	private static String searchVisitor="SELECT * FROM visitors WHERE username=?"; //Busca un visitante por username 
	
	private static String updateVisitor="UPDATE visitors SET username=?,firstname=?,lastname=?,email=?,phone_number=?,address=?,dni=? WHERE id=?"; //Actualiza los datos de un visitante (A excepción de la password)
	
	private static String changePWDQuery="UPDATE visitors SET password=? WHERE id=?"; //actualiza la password de un visitante dado
	
	
	
	//SQL queries for EVENTSIGNUPDAO
	private static String registerVisitorToEvent="INSERT INTO events_signup(id,visitor_id,event_id) VALUES(?,?,?)"; //Crea un nuevo registro en la tabla signup
	
	private static String deleteEventSessionSignup="DELETE FROM events_signup WHERE event_id = ?"; //Borra las ocurrencias de un evento de la tabla signup
	
	private static String checkEvent="SELECT * FROM events_signup WHERE visitor_id=? AND event_id=?" ;//Comprueba si un visitante está registrado a un evento
	
	private static String eventsRegistered="SELECT DISTINCT E1.id, E1.name, E1.description, E1.places, E1.duration, E1.event_type, E1.seats_available  FROM events E1, events_signup E2  WHERE E1.id= E2.event_id  AND E2.visitor_id=?";//Obtiene todos los eventos en los que está registrado un visitante dado
//statusQuery
	private static String unRegisterVisitorToEvent="DELETE FROM events_signup WHERE visitor_id=? AND event_id=?" ;//Borra el registro de la tabla signup para un visitante y evento dado
	
	
	//SQL queries for SEQUENCERDAO
	private static String sequencerActual="SELECT value FROM sequencer WHERE name=? "; //Obtiene el ultimo id asignado de la tabla sequencer
	private static String actualizaSequencer="UPDATE sequencer SET value=value+1 WHERE name=? "; //Actualiza la tabla sequence para incrementar el último id asignado
	
	
	
	public static final String getAllEvents() {
		return allEvents;
	}
	public static final void setAllEvents(String allEvents) {
		FERSDbQuery.allEvents = allEvents;
	}
	public static final String getSearchByEventName() {
		return searchByEventName;
	}
	public static final void setSearchByEventName(String searchByEventName) {
		FERSDbQuery.searchByEventName = searchByEventName;
	}
	public static final String getUpdateSeatsEventDec() {
		return updateSeatsEventDec;
	}
	public static final void setUpdateSeatsEventDec(String updateSeatsEventDec) {
		FERSDbQuery.updateSeatsEventDec = updateSeatsEventDec;
	}
	public static final String getUpdateSeatsEventInc() {
		return updateSeatsEventInc;
	}
	public static final void setUpdateSeatsEventInc(String updateSeatsEventInc) {
		FERSDbQuery.updateSeatsEventInc = updateSeatsEventInc;
	}
	public static final String getGetEvent() {
		return getEvent;
	}
	public static final void setGetEvent(String getEvent) {
		FERSDbQuery.getEvent = getEvent;
	}
	public static final String getUpdateEvent() {
		return updateEvent;
	}
	public static final void setUpdateEvent(String updateEvent) {
		FERSDbQuery.updateEvent = updateEvent;
	}
	public static final String getInsertEvent() {
		return insertEvent;
	}
	public static final void setInsertEvent(String insertEvent) {
		FERSDbQuery.insertEvent = insertEvent;
	}
	public static final String getDeleteEvent() {
		return deleteEvent;
	}
	public static final void setDeleteEvent(String deleteEvent) {
		FERSDbQuery.deleteEvent = deleteEvent;
	}
	public static final String getInsertVisitor() {
		return insertVisitor;
	}
	public static final void setInsertVisitor(String insertVisitor) {
		FERSDbQuery.insertVisitor = insertVisitor;
	}
	public static final String getSearchVisitor() {
		return searchVisitor;
	}
	public static final void setSearchVisitor(String searchVisitor) {
		FERSDbQuery.searchVisitor = searchVisitor;
	}
	public static final String getUpdateVisitor() {
		return updateVisitor;
	}
	public static final void setUpdateVisitor(String updateVisitor) {
		FERSDbQuery.updateVisitor = updateVisitor;
	}
	public static final String getChangePWDQuery() {
		return changePWDQuery;
	}
	public static final void setChangePWDQuery(String changePWDQuery) {
		FERSDbQuery.changePWDQuery = changePWDQuery;
	}
	public static final String getRegisterVisitorToEvent() {
		return registerVisitorToEvent;
	}
	public static final void setRegisterVisitorToEvent(String registerVisitorToEvent) {
		FERSDbQuery.registerVisitorToEvent = registerVisitorToEvent;
	}
	public static final String getDeleteEventSessionSignup() {
		return deleteEventSessionSignup;
	}
	public static final void setDeleteEventSessionSignup(
			String deleteEventSessionSignup) {
		FERSDbQuery.deleteEventSessionSignup = deleteEventSessionSignup;
	}
	public static final String getCheckEvent() {
		return checkEvent;
	}
	public static final void setCheckEvent(String checkEvent) {
		FERSDbQuery.checkEvent = checkEvent;
	}
	public static final String getEventsRegistered() {
		return eventsRegistered;
	}
	public static final void setEventsRegistered(String eventsRegistered) {
		FERSDbQuery.eventsRegistered = eventsRegistered;
	}
	public static final String getUnRegisterVisitorToEvent() {
		return unRegisterVisitorToEvent;
	}
	public static final void setUnRegisterVisitorToEvent(
			String unRegisterVisitorToEvent) {
		FERSDbQuery.unRegisterVisitorToEvent = unRegisterVisitorToEvent;
	}
	public static final String getSequencerActual() {
		return sequencerActual;
	}
	public static final void setSequencerActual(String sequencerActual) {
		FERSDbQuery.sequencerActual = sequencerActual;
	}
	public static final String getActualizaSequencer() {
		return actualizaSequencer;
	}
	public static final void setActualizaSequencer(String actualizaSequencer) {
		FERSDbQuery.actualizaSequencer = actualizaSequencer;
	}


	

	
	

}
