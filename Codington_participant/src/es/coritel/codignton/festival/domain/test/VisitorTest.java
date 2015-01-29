package es.coritel.codignton.festival.domain.test;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DomainException;
import junit.framework.TestCase;

public class VisitorTest extends TestCase {

	private Visitor v ;
	protected void setUp() throws Exception {
		super.setUp();
		v=new Visitor();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testVisitor() {
		fail("Not yet implemented");
	}

	public void testVisitorVisitor() {
		fail("Not yet implemented");
	}

	public void testGetVisitorId() {
		fail("Not yet implemented");
	}

	public void testSetVisitorId() {
		v.setVisitorId(4585);
		assertEquals(4585,(v.getVisitorId()));
	}
	
	
	//public void testSetVisitorIdNoValido(){
		//try{
			//v.setVisitorId();
		//}catch(DomainException e){
			//System.out.println(e.toString());
		//}
	//}

	public void testGetUserName() {
		fail("Not yet implemented");
	}

	public void testSetUserName() {
		v.setUserName("AdaCab");
		assertEquals("AdaCab",(v.getUserName()));
	}

	public void testGetPassword() {
		fail("Not yet implemented");
	}

	public void testGetUserNameNoValido(){
		try{
			v.setUserName("A");
		}catch(DomainException e){
			System.out.println(e.toString());
		}
	}
	public void testSetPassword() {
		v.setPassword("holapepito");
		assertEquals("holapepito",(v.getPassword()));
	}
	
	public void testGetPasswordNoValido(){
		try{
			v.setPassword("");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
	}

	public void testIsAdmin() {
		fail("Not yet implemented");
	}

	public void testSetAdmin() {
		fail("Not yet implemented");
	}

	public void testPeople() {
		fail("Not yet implemented");
	}

	public void testPeoplePeople() {
		fail("Not yet implemented");
	}

	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	public void testGetLastName() {
		fail("Not yet implemented");
	}

	public void testSetLastName() {
		fail("Not yet implemented");
	}

	public void testGetDni() {
		fail("Not yet implemented");
	}

	public void testSetDni() {
		fail("Not yet implemented");
	}

	public void testGetEmail() {
		fail("Not yet implemented");
	}

	public void testSetEmail() {
		fail("Not yet implemented");
	}

	public void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

	public void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

	public void testGetAddress() {
		fail("Not yet implemented");
	}

	public void testSetAddress() {
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
