package es.coritel.codington.festival.utils;


public class Validator
{

	/**
	 * M�todo que valida la longitud de una cadena, permite valores nulos
	 * 
	 * @param cadena
	 *            Cadena de car�cteres que se valida
	 * @param minLongitud
	 *            Longitud m�nima que debe cumplir la cadena
	 * @param maxLongitud
	 *            Longitud m�xima que debe cumplir la cadena
	 * 
	 * @return true la longitud de la cadena es v�lida, false la longitud de la
	 *         cadena no es v�lida
	 */
	public static boolean validateLongitud(String cadena, int minLongitud,
			int maxLongitud)
	{
		boolean success = false;

		if (cadena != null)
		{
			if ((cadena.length() >= minLongitud)
					&& (cadena.length() <= maxLongitud))
			{
				success = true;
			}
		} 

		return success;
	}

}
