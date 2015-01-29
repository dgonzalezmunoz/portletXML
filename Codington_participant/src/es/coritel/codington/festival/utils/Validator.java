package es.coritel.codington.festival.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Clase que maneja las validaciones de los formatos de los datos de la
 * aplicación
 * 
 */
public class Validator {

	
    public static boolean validateLongName(String name, int min, int max){
		
		if (name.length()>=min && name.length()<=max)
			return true;
		return false;
	}
    public static boolean validateEmail(String email, int min, int max){
		 if(validateLongName(email, min, max)){
			 Pattern pat= Pattern.compile("[^()\\[\\];:,<>\\s@]+@[\\w]+\\.([\\w]{2,6})$");
		     Matcher mat= pat.matcher(email);
		     if(mat.find()) return true;
		 }
		 return false;
	 }
    
    private final static String TABLA_ASIGNACION_LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static boolean validateDNI(String dni, int min, int max){
		 if(validateLongName(dni, min, max)){
			 Pattern pat= Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}-[A-Za-z]");
			 Matcher mat=pat.matcher(dni);
			 if(mat.find()){ 
				 
				 String f= dni.substring(0,2)+dni.substring(3,6)+dni.substring(7,10);
				 //System.out.println(f);
				 if(TABLA_ASIGNACION_LETRA_DNI.charAt(Integer.parseInt(f)%23)==dni.charAt(dni.length()-1)){
					return true;
				 }
				 else return false;
			 }
		 }
		 return false;
	 }
	 
	 public static boolean validatePhoneNumber(String phoneNumber, int min, int max){
		 if(validateLongName(phoneNumber, min, max)){
			 Pattern pat= Pattern.compile("\\+?[\\d*\\s*]*");
			 Matcher mat= pat.matcher(phoneNumber);
			 if(mat.find()) return false;
		 }
		 return true;
	 }
	 

	 
	
	//clase People
	public final static int MIN_LONG_FIRSTNAME=1;
	public final static int MAX_LONG_FIRSTNAME=30;
	public final static int MIN_LONG_LASTNAME=1;
	public final static int MAX_LONG_LASTNAME=30;
	public final static int LONG_DNI=12;
	public final static int MIN_LONG_EMAIL=3;
	public final static int MAX_LONG_EMAIL=200;
	public final static int MIN_LONG_PHONE=10;
	public final static int MAX_LONG_PHONE=20;
	public final static int MIN_LONG_ADDRESS=0;
	public final static int MAX_LONG_ADDRESS=30;
		
		
		
	//clase Visitor
	//private final static int MIN_LONG_VISITORID=
	public final static int MIN_LONG_USERNAME=6;
	public final static int MAX_LONG_USERNAME=12;
	public final static int MIN_LONG_PASSWORD=6;
	public final static int MAX_LONG_PASSWORD=15;
	
	
	//clase Event
	public final static int MIN_LONG_NAME=1;
	public final static int MAX_LONG_NAME=45;
	public final static int MIN_LONG_DESCRIPTION=1;
	public final static int MAX_LONG_DESCRIPTION=45;
	public final static int MIN_LONG_PLACE=1;
	public final static int MAX_LONG_PLACE=45;
	public final static int MIN_LONG_DURATION=1;
	public final static int MAX_LONG_DURATION=45;
	public final static int MIN_LONG_EVENTTYPE=1;
	public final static int MAX_LONG_EVENTTYPE=45;

}
