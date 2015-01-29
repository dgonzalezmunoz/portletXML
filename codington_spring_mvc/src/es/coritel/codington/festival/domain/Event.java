package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

public class Event
{

	// Mínima longitud aceptada para el nombre
	private final static int MIN_LONGITUD_NAME = 1;

	// Máxima longitud aceptada para el nombre
	private final static int MAX_LONGITUD_NAME = 45;

	// Mínima longitud aceptada para la descripción
	private final static int MIN_LONGITUD_DESCRIPCION = 1;

	// Máxima longitud aceptada para la descripción
	private final static int MAX_LONGITUD_DESCRIPCION = 45;

	// Mínima longitud aceptada para el lugar
	private final static int MIN_LONGITUD_PLACE = 1;

	// Máxima longitud aceptada para el lugar
	private final static int MAX_LONGITUD_PLACE = 45;

	// Mínima longitud aceptada para la duración
	private final static int MIN_LONGITUD_DURATION = 1;

	// Máxima longitud aceptada para la duración
	private final static int MAX_LONGITUD_DURATION = 45;

	// Mínima longitud aceptada para el tipo de evento
	private final static int MIN_LONGITUD_EVENT_TYPE = 1;

	// Máxima longitud aceptada para el tipo de evento
	private final static int MAX_LONGITUD_EVENT_TYPE = 45;

	// Menor valor posible para el identificador de evento
	private final static int MIN_EVENT_ID = 0;

	/** Mensaje de error a mostrar cuando el nombre no es válido */
	public final static String MENSAJE_ERROR_NAME = "Invalid Name";

	/** Mensaje de error a mostrar cuando la descripción no es válida */
	public final static String MENSAJE_ERROR_DESCRIPCION = "Invalid Description";

	/** Mensaje de error a mostrar cuando el lugar no es válido */
	public final static String MENSAJE_ERROR_PLACE = "Invalid Place";

	/** Mensaje de error a mostrar cuando la duración no es válida */
	public final static String MENSAJE_ERROR_DURATION = "Invalid Duration";

	/** Mensaje de error a mostrar cuando el tipo de evento no es válido */
	public final static String MENSAJE_ERROR_EVENT_TYPE = "Invalid Event Type";

	/**
	 * Mensaje de error a mostrar cuando el identificador de evento no es válido
	 */
	public final static String MENSAJE_ERROR_EVENT_ID = "Invalid Event ID";

	/** Mensaje de error a mostrar cuando el número de asientos no es válido */
	public final static String MENSAJE_ERROR_SEATS_A_EVENT = "Invalid number of seats";

	// Identificador del evento
	private int eventId;

	// Nombre del evento
	private String name;

	// Descripción del evento
	private String description;

	// Lugar del evento
	private String place;

	// Duración del evento
	private String duration;

	// Tipo de evento
	private String eventType;

	// Asientos en el evento
	private int seatsAEvent;

	/**
	 * Constructor por defecto del evento, crea un evento vacio
	 */
	public Event()
	{

	}

	/**
	 * Constructor de copia, crea un evento copiando los atributos de otro
	 * 
	 * @param eventoCopia
	 *            Evento que se va a copiar
	 */
	public Event(Event eventoCopia)
	{
		this.eventId = eventoCopia.getEventId();
		this.name = eventoCopia.getName();
		this.description = eventoCopia.getDescription();
		this.place = eventoCopia.getPlace();
		this.duration = eventoCopia.getDuration();
		this.eventType = eventoCopia.getEventType();
		this.seatsAEvent = eventoCopia.getSeatsAEvent();
	}

	/**
	 * Devuelve el identificador del evento
	 * 
	 * @return Identificador del evento
	 */
	public int getEventId()
	{
		return eventId;
	}

	/**
	 * Modifica el identificador del evento, si no es un identificador válido se
	 * lanza una excepción informativa
	 * 
	 * @param eventId
	 *            Nuevo identificador del evento
	 * @see DomainException
	 */
	public void setEventId(int eventId)
	{
		if (eventId >= MIN_EVENT_ID)
		{
			this.eventId = eventId;
		} else
		{
			DomainException excepcion = new DomainException(
					MENSAJE_ERROR_EVENT_ID);

			throw excepcion;
		}
	}

	/**
	 * Devuelve el nombre del evento
	 * 
	 * @return Nombre del evento
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Modifica el nombre del evento si el formato es aceptado, sino se lanza
	 * una excepción informativa
	 * 
	 * @param name
	 *            Nuevo nombre del evento
	 * @see DomainException
	 */
	public void setName(String name)
	{
		// se valida el formato del nombre antes de asignarlo
		if (Validator.validateLongitud(name, MIN_LONGITUD_NAME,
				MAX_LONGITUD_NAME))
		{
			this.name = name;
		} else
		{
			DomainException excepcion = new DomainException(MENSAJE_ERROR_NAME);

			throw excepcion;
		}
	}

	/**
	 * Devuelve la descripción del evento
	 * 
	 * @return Descripción del evento
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Modifica la descripción del evento si el formato es aceptado, sino lanza
	 * una excepción informativa
	 * 
	 * @param descripcion
	 *            Nueva descripción para el evento
	 * @see DomainException
	 */
	public void setDescription(String descripcion)
	{
		// se valida el formato de la descripción antes de asignarla
		if (Validator.validateLongitud(descripcion, MIN_LONGITUD_DESCRIPCION,
				MAX_LONGITUD_DESCRIPCION))
		{
			this.description = descripcion;
		} else
		{
			DomainException excepcion = new DomainException(
					MENSAJE_ERROR_DESCRIPCION);

			throw excepcion;
		}
	}

	/**
	 * Devuelve el lugar del evento
	 * 
	 * @return Lugar del evento
	 */
	public String getPlace()
	{
		return place;
	}

	/**
	 * Modifica el lugar del evento si el formato es aceptado, sino lanza una
	 * excepción informativa
	 * 
	 * @param place
	 *            Nuevo lugar para el evento
	 * @see DomainException
	 */
	public void setPlace(String place)
	{
		// se valida el formato del lugar antes de asignarlo
		if (Validator.validateLongitud(place, MIN_LONGITUD_PLACE,
				MAX_LONGITUD_PLACE))
		{
			this.place = place;
		} else
		{
			DomainException excepcion = new DomainException(MENSAJE_ERROR_PLACE);

			throw excepcion;
		}
	}

	/**
	 * Devuelve la duración del evento
	 * 
	 * @return Duración del evento
	 */
	public String getDuration()
	{
		return duration;
	}

	/**
	 * Modifica la duración del evento si el formato es aceptado, sino se lanza
	 * una excepción informativa
	 * 
	 * @param duration
	 *            Nueva duración para el evento
	 * @see DomainException
	 */
	public void setDuration(String duration)
	{
		// se valida el formato de la duración antes de asignarlo
		if (Validator.validateLongitud(duration, MIN_LONGITUD_DURATION,
				MAX_LONGITUD_DURATION))
		{
			this.duration = duration;
		} else
		{
			DomainException excepcion = new DomainException(
					MENSAJE_ERROR_DURATION);

			throw excepcion;
		}
	}

	/**
	 * Devuelve el tipo de evento
	 * 
	 * @return Tipo de evento
	 */
	public String getEventType()
	{
		return eventType;
	}

	/**
	 * Modifica el tipo de evento si el formato es aceptado, sino se lanza una
	 * excepción informativa
	 * 
	 * @param eventType
	 *            Nuevo tipo de evento a asignar
	 * @see DomainException
	 */
	public void setEventType(String eventType)
	{
		// se valida el formato del tipo de evento antes de asignarlo
		if (Validator.validateLongitud(eventType, MIN_LONGITUD_EVENT_TYPE,
				MAX_LONGITUD_EVENT_TYPE))
		{
			this.eventType = eventType;
		} else
		{
			DomainException excepcion = new DomainException(
					MENSAJE_ERROR_EVENT_TYPE);

			throw excepcion;
		}
	}

	/**
	 * Devuelve los asientos del evento
	 * 
	 * @return Asientos del evento
	 */
	public int getSeatsAEvent()
	{
		return seatsAEvent;
	}

	/**
	 * Modifica los asientos que tiene el evento si su valor es el mínimo
	 * aceptado, sino se lanza una excepción informativa
	 * 
	 * @param seatsAEvent
	 *            Nuevo valor para los asientos que tiene el evento
	 * @see DomainException
	 */
	public void setSeatsAEvent(int seatsAEvent)
	{
		this.seatsAEvent = seatsAEvent;
	}

	/**
	 * Devuelve el código hash del evento
	 * 
	 * @return Código hash del evento
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + eventId;
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAEvent;
		return result;
	}

	/**
	 * Indica si un evento dado tiene los mismos atributos que el evento actual
	 * 
	 * @param obj
	 *            Objeto que es el evento con el que se quiere comparar la
	 *            igualdad
	 * 
	 * @return true si los dos eventos son iguales, false si los eventos no son
	 *         iguales
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null)
		{
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventType == null)
		{
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null)
		{
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seatsAEvent != other.seatsAEvent)
			return false;
		return true;
	}

}
