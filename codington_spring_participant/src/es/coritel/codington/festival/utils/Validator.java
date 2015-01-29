package es.coritel.codington.festival.utils;


public class Validator
{

	/**
	 * Método que valida la longitud de una cadena, permite valores nulos
	 * 
	 * @param cadena
	 *            Cadena de carácteres que se valida
	 * @param minLongitud
	 *            Longitud mínima que debe cumplir la cadena
	 * @param maxLongitud
	 *            Longitud máxima que debe cumplir la cadena
	 * 
	 * @return true la longitud de la cadena es válida, false la longitud de la
	 *         cadena no es válida
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
