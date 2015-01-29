package es.coritel.codignton.festival.domain.test;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DomainException;
import junit.framework.TestCase;

public class EventTest extends TestCase {
	
	private Event e;

	protected void setUp() throws Exception {
		super.setUp();
		e=new Event();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEvent() {
		fail("Not yet implemented");
	}

	public void testEventEvent() {
		fail("Not yet implemented");
	}

	public void testGetEventId() {
		fail("Not yet implemented");
	}

	public void testSetEventId() {
		e.setEventId(25);
		assertEquals(25, (e.getEventId()));
	}
	
	//public void testGetEventIdNoValido(){
		//try{
			//e.setEventId();
		//}catch(DomainException e){
			//System.out.println(e.toString());
		//}
	//}


	public void testGetName() {
		fail("Not yet implemented");
	}

	public void testSetName() {
		e.setName("Concert");
		assertEquals("Concert", (e.getName()));
	}

	public void testSetNameNoValido(){
		try{
			e.setName("");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	public void testSetDescription() {
		e.setDescription("Big concert");
		assertEquals("Big concert", (e.getDescription()));
	}
	
	public void testSetDescriptionNoValido(){
		try{
			e.setDescription("ajdaskjkajklajklfieikdnkfjklilfjfmfiajajajlfjalnknafnklah");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}

	public void testGetPlace() {
		fail("Not yet implemented");
	}

	public void testSetPlace() {
		e.setPlace("Sant Cugat");
		assertEquals("Sant Cugat",(e.getPlace()));
	}
	
	public void testSetPlaceNoValido(){
		try{
			e.setPlace("fdjsdjksdkjsldfjkjklsjklsdfjiduijsksksdfsdfsjkksdjfklsdklfjk");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}

	public void testGetDuration() {
		fail("Not yet implemented");
	}

	public void testSetDuration() {
		e.setDuration("Two days");
		assertEquals("Two days", (e.getDuration()));
	}
	
	public void testSetDurationNoValido(){
		try{
			e.setDuration("");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}

	public void testGetEventType() {
		fail("Not yet implemented");
	}

	public void testSetEventType() {
		e.setEventType("Entertaiment");
		assertEquals("Entertaiment", (e.getEventType()));
	}

	public void testSetEventTypeNoValido(){
		try{
			e.setEventType("");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testGetSeatsAEvent() {
		fail("Not yet implemented");
	}

	public void testSetSeatsAEvent() {
		fail("Not yet implemented");
	}

	public void testObject() {
		fail("Not yet implemented");
	}

	public void testGetClass() {
		fail("Not yet implemented");
	}

	public void testHashCode() {
		fail("Not yet implemented");
	}

	public void testEquals() {
		fail("Not yet implemented");
	}

	public void testClone() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

	public void testNotify() {
		fail("Not yet implemented");
	}

	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	public void testWaitLong() {
		fail("Not yet implemented");
	}

	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	public void testWait() {
		fail("Not yet implemented");
	}

	public void testFinalize() {
		fail("Not yet implemented");
	}

}
