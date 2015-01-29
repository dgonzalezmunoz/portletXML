package es.coritel.codington.festival.exceptions;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException
{

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public DomainException(String message)
	{
		super(message);
	}
}
