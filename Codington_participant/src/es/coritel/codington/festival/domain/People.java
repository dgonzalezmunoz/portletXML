package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 * POJO for PEOPLE class which is PARENT CLASS for Visitor
 */
public class People {

	
	private String firstName; // Nombre
	private String lastName; // Apellido
	private String dni; // dni
	private String email; // Correo electrónico
	private String phoneNumber; // Número de teléfono 
	private String address;//Dirección 
	
	private static final String MENSAJE_ERROR_FIRSTNAME = "Invalid FirstName";
	private static final String MENSAJE_ERROR_LASTNAME = "Invalid LastName";
	private static final String MENSAJE_ERROR_DNI = "Invalid DNI";
	private static final String MENSAJE_ERROR_EMAIL ="Invalid Email ID" ;
	private static final String MENSAJE_ERROR_PHONENUMBER ="Invalid Phone number" ;
	private static final String MENSAJE_ERROR_ADDRESS = "Invalid Address ";
	/**
	 * Constructor por defecto de una persona, crea una persona vacia
	 */
	public People(){}
	
	/**
	 * Constructor de copia, crea un objeto People copiando los atributos de otro
	 * 
	 * @param people	Persona que se va a copiar
	 */
	public People(People people){
		this.firstName=people.firstName;
		this.lastName=people.lastName;
		this.dni=people.dni;
		this.email=people.email;
		this.phoneNumber=people.phoneNumber;
		this.address=people.address;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		if(Validator.validateLongName(firstName, Validator.MIN_LONG_FIRSTNAME, Validator.MAX_LONG_FIRSTNAME)){
		     this.firstName = firstName;
		     //System.out.println("Nombre correcto "+ firstName);
		}else throw new DomainException (MENSAJE_ERROR_FIRSTNAME);
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		if(Validator.validateLongName(lastName, Validator.MIN_LONG_LASTNAME, Validator.MAX_LONG_LASTNAME)){
			this.lastName = lastName;
			//System.out.println("LastName correcto "+ lastName);
		}else throw new DomainException (MENSAJE_ERROR_LASTNAME);
	}
	
	public final String getDni() {
		return dni;
	}
	public final void setDni(String dni) {
		if(Validator.validateDNI(dni, Validator.LONG_DNI, Validator.LONG_DNI)){
			this.dni = dni;
			//System.out.println("DNI válido "+ dni);
		}else throw new DomainException (MENSAJE_ERROR_DNI);
		
	}
	public final String getEmail() {
		return email;
	}
		
	public final void setEmail(String email) {
		if(Validator.validateEmail(email, Validator.MIN_LONG_EMAIL, Validator.MAX_LONG_EMAIL)){
			this.email = email;
			//System.out.println("Email correcto "+ email);
		}else  throw new DomainException (MENSAJE_ERROR_EMAIL);
	}
	
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final void setPhoneNumber(String phoneNumber) {
		if(Validator.validatePhoneNumber(phoneNumber, Validator.MIN_LONG_PHONE, Validator.MAX_LONG_PHONE)){
			this.phoneNumber = phoneNumber;
			//System.out.println("Phone Number correcto "+ phoneNumber);
		}else throw new DomainException (MENSAJE_ERROR_PHONENUMBER);
	}
	
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		if(Validator.validateLongName(address, Validator.MIN_LONG_ADDRESS, Validator.MAX_LONG_ADDRESS)){
			this.address = address;
			//System.out.println("Address correct "+ address);
		}else throw new DomainException (MENSAJE_ERROR_ADDRESS);
		
	}
	
	
}



