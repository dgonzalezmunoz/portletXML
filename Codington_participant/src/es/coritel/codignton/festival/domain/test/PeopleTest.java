package es.coritel.codignton.festival.domain.test;

import es.coritel.codington.festival.domain.People;
import es.coritel.codington.festival.exceptions.DomainException;
import junit.framework.TestCase;

public class PeopleTest extends TestCase {
	
	private People p;
	
	protected void setUp() throws Exception {
		super.setUp();
		p= new People();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testsetFirstName(){
		p.setFirstName("Ada");
		assertEquals("Ada",(p.getFirstName()));
	}
	
	public void testsetFirstNameNoValido(){
		try{
			p.setFirstName("");
		}catch(DomainException e){
			//fail("Invalid FirstName");
			System.out.println(e.toString());
		}
	}
	
	public void testsetLastName(){
		p.setLastName("Cabanas");
		assertEquals("Cabanas",(p.getLastName()));
	}
	
	public void testsetLastNameNoValido(){
		try{
			p.setLastName("qwertyuiopñlkjhgfdsazxcvbnmqwer");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testsetDni(){
		p.setDni("53.294.894-F");
		assertEquals("53.294.894-F",(p.getDni()));
	}
	
	public void testsetDniNoValido(){
		try{
			p.setDni("53294894F");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testsetEmail(){
		p.setEmail("ada@mail.com");
		assertEquals("ada@mail.com", (p.getEmail()));
	}
	
	public void testsetEmailNoValido(){
		try{
			p.setEmail("a@a");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testsetPhoneNumber(){
		p.setPhoneNumber("000000000");
		assertEquals("000000000", (p.getPhoneNumber()));
	}
	
	public void testsetPhoneNumberNoValido(){
		try{
			p.setPhoneNumber("444f5555555");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
	}
	
	public void testsetAddress(){
		p.setAddress("Carrer major");
		assertEquals("Carrer major", (p.getAddress()));
	}
	
	public void testsetAddressNoValido(){
		try{
			p.setAddress("chahdjahjkfhfhfhajffjjfjfjfaasda");
		}catch (DomainException e){
			System.out.println(e.toString());
		}
		
		
	}
}
