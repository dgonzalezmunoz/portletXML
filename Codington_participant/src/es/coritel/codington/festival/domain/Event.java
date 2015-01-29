package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 * POJO class for Event
 */
public class Event {

	private int eventId;// Identificador del evento
	private String name;// Nombre del evento
	private String description;// Descripción del evento
	private String place;// Lugar del evento
	private String duration;// Duración del evento
	private String eventType;// Tipo de evento
	private int seatsAEvent;// Asientos disponibles en el evento
	
	
	//private static final String MENSAJE_ERROR_EVENTID = "";
	private static final String MENSAJE_ERROR_NAME = "Invalid Event Name";
	private static final String MENSAJE_ERROR_DESCRIPTION = "Invalid Event Description";
	private static final String MENSAJE_ERROR_PLACE = "Invalid Event Place";
	private static final String MENSAJE_ERROR_DURATION = "Invalid Event Duration";
	private static final String MENSAJE_ERROR_EVENTTYPE = "Invalid Event Type";
	//private static final String MENSAJE_ERROR_SEATSAEVENT = "Invalid SeatsAvailable";
	
	/**
	 * Constructor por defecto de Event, crea un evento vacio
	 */
	public Event(){}
	
	/**
	 * Constructor de copia, crea un objeto Event copiando los atributos de otro
	 * 
	 * @param event	Evento que se va a copiar
	 */
	public Event(Event event){
		this.eventId=event.eventId;
		this.name=event.name;
		this.description=event.description;
		this.place=event.place;
		this.duration=event.duration;
		this.eventType=event.eventType;
		this.seatsAEvent=event.seatsAEvent;
	}

	public final int getEventId() {
		return eventId;
	}

	public final void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		if(Validator.validateLongName(name, Validator.MIN_LONG_NAME, Validator.MAX_LONG_NAME)){
			this.name = name;
			//System.out.println("Nombre correcto "+ name);
		}else throw new DomainException (MENSAJE_ERROR_NAME);
		
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		if(Validator.validateLongName(description, Validator.MIN_LONG_DESCRIPTION, Validator.MAX_LONG_DESCRIPTION)){
			this.description = description;
			//System.out.println("Descripción: " + description);
		}else  throw new DomainException (MENSAJE_ERROR_DESCRIPTION);
	}

	public final String getPlace() {
		return place;
	}

	public final void setPlace(String place) {
		if(Validator.validateLongName(place, Validator.MIN_LONG_PLACE, Validator.MAX_LONG_PLACE)){
			this.place = place;
			//System.out.println("Place "+ place);
		}else throw new DomainException (MENSAJE_ERROR_PLACE);
	}

	public final String getDuration() {
		return duration;
	}

	public final void setDuration(String duration) {
		if(Validator.validateLongName(duration, Validator.MIN_LONG_DURATION, Validator.MAX_LONG_DURATION)){
			this.duration = duration;
			//System.out.println("Duration "+ duration);
		}else throw new DomainException (MENSAJE_ERROR_DURATION);
	}

	public final String getEventType() {
		return eventType;
	}

	public final void setEventType(String eventType) {
		if(Validator.validateLongName(eventType, Validator.MIN_LONG_EVENTTYPE, Validator.MAX_LONG_EVENTTYPE)){
			this.eventType = eventType;
			//System.out.println("Event type "+ eventType);
		}else throw new DomainException (MENSAJE_ERROR_EVENTTYPE);
		
	}

	public final int getSeatsAEvent() {
		return seatsAEvent;
	}

	public final void setSeatsAEvent(int seatsAEvent) {
		if(seatsAEvent>0)
			this.seatsAEvent = seatsAEvent;
	}

}