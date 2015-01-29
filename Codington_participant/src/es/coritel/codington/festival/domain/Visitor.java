package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 *	POJO for VISITOR CLASS
 */
public class Visitor extends People {
	
		

		//Identificador del visitante
		private int visitorId;
		
		private String userName;// Nombre de usuario utilizado en el portal web

		private String password; // Contraseña del usuario
		
		//Booleano que indica si el visitante es administrador o no
		private boolean admin;
		
		private static final String MENSAJE_ERROR_USERNAME = "Invalid username";
		private static final String MENSAJE_ERROR_PASSWORD = "Invalid Password";

	
		/**
		 * Constructor por defecto, crea un visitante vacio
		 */
		public Visitor(){}
		
		/**
		 * Constructor de copia, crea un objeto Vistor copiando los atributos de otro
		 */
		public Visitor(Visitor visitor){
			this.visitorId=visitor.visitorId;
			this.userName=visitor.userName;
			this.password=visitor.password;
			this.admin=visitor.admin;
		}
		
		
				
		public final int getVisitorId() {
			return visitorId;
		}

		public final void setVisitorId(int visitorId) {
			this.visitorId = visitorId;
		}

		public final String getUserName() {
			return userName;
		}

		public final void setUserName(String userName) {
			if(Validator.validateLongName(userName, Validator.MIN_LONG_USERNAME, Validator.MAX_LONG_USERNAME)){
				this.userName = userName;
				//System.out.println("UserName correcto "+ userName);
			}else throw new DomainException (MENSAJE_ERROR_USERNAME);
		}

		public final String getPassword() {
			return password;
		}

		public final void setPassword(String password) {
			if(Validator.validateLongName(password, Validator.MIN_LONG_PASSWORD, Validator.MAX_LONG_PASSWORD)){
				this.password = password;
				//System.out.println("Password correcto ");
			}else throw new DomainException (MENSAJE_ERROR_PASSWORD);
			
		}

		public final boolean isAdmin() {
			return admin;
		}

		public final void setAdmin(boolean admin) {
			this.admin = admin;
		}
}
