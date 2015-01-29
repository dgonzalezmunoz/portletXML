package es.coritel.codington.festival.domain;
/**
 * POJO class for EventSignUp
 */

public class EventSignUp {

	private int id; //identificador unico
	private int idVisitor; //id del visitante
	private int idEvent; //id del evento
	
	public EventSignUp(){}
	
	public EventSignUp(EventSignUp eventSignUp){
		this.id=eventSignUp.id;
		this.idVisitor=eventSignUp.idVisitor;
		this.idEvent=eventSignUp.idEvent;
	}
	

	
	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final int getIdVisitor() {
		return idVisitor;
	}

	public final void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	public final int getIdEvent() {
		return idEvent;
	}

	public final void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}


}
