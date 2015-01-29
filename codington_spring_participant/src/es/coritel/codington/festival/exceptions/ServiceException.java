package es.coritel.codington.festival.exceptions;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException
{

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public ServiceException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 *            ,cause
	 */
	public ServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
