package es.coritel.codington.festival.utils;

/**
 * Helper class for externalization of queries
 */
public class FERSDbQuery
{

	// SQL queries for EVENTDAO
	private static String allEvents = "SELECT id, name, description, places, duration, event_type, seats_available FROM events";
	private static String insertEvent = "INSERT INTO events(id, name, description, places, duration, event_type,seats_available) VALUES(?,?,?,?,?,?,?)";
	// SQL queries for SEQUENCERDAO
	private static String sequencerActual = "SELECT value FROM sequencer WHERE name=? ";
	private static String actualizaSequencer = "UPDATE sequencer SET value=value+1 WHERE name=? ";

	/**
	 * Devuelve la query que obtiene todos eventos de la base de datos
	 * 
	 * @return allEvents
	 */
	public static String getAllEvents()
	{
		return allEvents;
	}
	/**
	 * Devuelve la query que inserta un evento
	 * @return insertEvent
	 */
	public static String getInsertEvent()
	{
		return insertEvent;
	}
	/**
	 * Devuelve la query que obtiene el ultimo id asignado
	 * @return sequencerActual
	 */
	public static String getSequencerActual()
	{
		return sequencerActual;
	}
	/**
	 * Devuelve la query que actualiza el ultimo id asignado
	 * @return actualizaSequencer
	 */
	public static String getActualizaSequencer()
	{
		return actualizaSequencer;
	}

}
