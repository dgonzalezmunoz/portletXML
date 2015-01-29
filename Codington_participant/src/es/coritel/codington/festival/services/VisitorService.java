package es.coritel.codington.festival.services;

import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.daos.DAOManager;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.exceptions.ServiceException;
import es.coritel.codington.festival.interfaces.daos.IEventSignUpDAO;
import es.coritel.codington.festival.interfaces.daos.ISequencerDAO;
import es.coritel.codington.festival.interfaces.daos.IVisitorDAO;
import es.coritel.codington.festival.interfaces.services.IVisitorService;

public class VisitorService implements IVisitorService {
	
	public VisitorService(){}
	
	/**
	 * SERVICE CLASS for inserting new visitor
	 * @param visitor
	 * @return status
	 * @throws ServiceException
	 */

	@Override
	public boolean createVisitor(Visitor visitor) throws ServiceException {
		// TODO Auto-generated method stub
		boolean insertStatus = false;
		DAOManager daoManager= null;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un IVisitorDAO del DaoManager (creem l'objecte de la interface)
			IVisitorDAO visitorDAO = daoManager.getVisitorDAO();
			
			//Comprobamos si el usuario existe previamente
			Visitor user=visitorDAO.searchUser(visitor);
			
			if(user ==null){
				//Obtenemos el SequencerDAO
				ISequencerDAO sequencerDAO=daoManager.getSequencerDAO();
				
				//Obtenemos el siguiente id del visitante
				int id=sequencerDAO.getNext(ISequencerDAO.CLASS_VISITOR_NAME);
				
				//le asignamos el id obtenido
				visitor.setVisitorId(id);
				
				//le damos de alta
				insertStatus= visitorDAO.insertData(visitor);
				
				insertStatus=true;
			}
			daoManager.closeOk();
		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException (e.getMessage());
		}
		return insertStatus;
	}
	
	/**
	 * SERVICE CLASS for searching visitor details
	 * @param visitor (requieres username is informed)
	 * @return visitor - found
	 * @throws ServiceException
	 * 
	 */
	@Override
	public Visitor searchVisitor(Visitor user) throws ServiceException {
		// TODO Auto-generated method stub
		
		Visitor visitor = new Visitor();
		DAOManager daoManager = null;
		try{
			daoManager = new DAOManager();
			
			//Obtenemos un IVisitorDAO del DAOMAnager
			IVisitorDAO visitorDAO=daoManager.getVisitorDAO();
			
			//Llamamos al dao que nos devuelve el visitante
			visitor=visitorDAO.searchUser(user);
			daoManager.closeOk();
		}catch (DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return visitor;
		
	}
	
    /**
	 * SERVICE CLASS for displaying all registered events
	 * @param visitor
	 * @return list<Event> registered
	 * @throws ServiceException
	 */
	@Override
	public List<Event> showRegisteredEvents(Visitor visitor) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager=null;
		List<Event> showEvents = new ArrayList<Event>();
		try{
			daoManager= new DAOManager();
			
			//Obtenemos un IvisitorDAO del DaoManager
			IEventSignUpDAO eventSignupDAO=daoManager.getIEventSignUpDAO();
			
			//Llamamos al dao que nos devuelve la lista de eventos para los cuales
			//está registrado el visitante con una instancia event_signup que contiene
			//el id del visitor
			EventSignUp eventSignUp = new EventSignUp();
			eventSignUp.setIdVisitor(visitor.getVisitorId());
			showEvents=eventSignupDAO.registeredEvents(eventSignUp);
			daoManager.closeOk();
			
		}catch(DAOException e){
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		
		return showEvents;
	}
	
	/**
	 * SERVICE CLASS for updating visitor details
	 * @param visitor
	 * @return status
	 * @throws ServiceException
	 */

	@Override
	public int updateVisitorDetails(Visitor visitor) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager = null;
		int status=0;
		try{
			daoManager=new DAOManager();
			
			//Obtenemos un IVisitorDAO del DaoManager
			IVisitorDAO visitorDAO=daoManager.getVisitorDAO();
			
			//Llamamos al dao que actualiza la información del visitante
			status=visitorDAO.updateVisitor(visitor);
			daoManager.closeOk();
			
		}catch (DAOException e){
			daoManager.closeError();
			status=-1;
		}
		
		return status;
	}

	/**
	 * SERVICE CLASS for updating visitor details
	 * @param visitor
	 * @return status
	 * @throws ServiceException
	 */
	@Override
	public int changePassword(Visitor visitor) throws ServiceException {
		// TODO Auto-generated method stub
		DAOManager daoManager=null;
		int status=0;
		try{
			daoManager= new DAOManager();
			
			//Obtenemos un IVisitorDAO del DaoManager
			IVisitorDAO visitorDAO=daoManager.getVisitorDAO();
			
			//Llamamos al dao que cambia el password
			status=visitorDAO.changePassword(visitor);
			daoManager.closeOk();
			
		}catch(DAOException e){
			daoManager.closeError();
		}
		return status;
	}

}
