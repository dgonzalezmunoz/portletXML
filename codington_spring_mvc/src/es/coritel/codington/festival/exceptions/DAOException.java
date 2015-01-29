package es.coritel.codington.festival.exceptions;


@SuppressWarnings("serial")
public class DAOException extends RuntimeException
{

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public DAOException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
