package com.codignton.servlet;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.VisitorService;

public class VisitorBean {
	
	private String user;
	private String pass;
	private String name;
	

	public VisitorBean() {
		super();
	}
	
	public final String getUser() {
		return user;
	}

	public final void setUser(String user) {
		this.user = user;
	}

	
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPass() {
		return pass;
	}
	public final void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getServiceNombre(){
		
		return pass;
	
	}
	

	
	public Visitor getBuscar(){
		
		VisitorService sv = new VisitorService();
		Visitor visitor = new Visitor();
		
		visitor.setUserName(user);
		Visitor visitorFound=sv.searchVisitor(visitor);
	
	return 	visitorFound;
	}
	

}
