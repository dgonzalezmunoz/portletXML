package es.coritel.codington.festival.daos;

import java.sql.Connection;

import es.coritel.codington.festival.utils.FERSDataConnection;

public class DAOManager {
	
	private Connection conn;
	private FERSDataConnection datacon= new FERSDataConnection();
	//getEventDAO;
	
	public DAOManager() {
		conn=datacon.getConnection();
	}
	
	
	
//	public EventDAOImpl1 getEventDAO(){
//		EventDAOImpl1 evDAO= new EventDAOImpl1(conn);
//		return evDAO;
//	}
	
//	public VisitorDAO getVisitorDAO(){
//		VisitorDAO vDAO=new VisitorDAO(conn);
//		return vDAO;
//	}
//	
//	public SequencerDAO getSequencerDAO(){
//		SequencerDAO sDAO=new SequencerDAO(conn);
//		return sDAO;
//	}
//	
//	public EventSignUpDAO getIEventSignUpDAO(){
//		EventSignUpDAO esuDAO=new EventSignUpDAO(conn);
//		return esuDAO;
//	}
	
	
	public void closeOk(){
		FERSDataConnection.commit(conn);
		FERSDataConnection.closeConnection(conn);
	}
	public void closeError(){
		FERSDataConnection.rollback(conn);
		FERSDataConnection.closeConnection(conn);
	}

}
