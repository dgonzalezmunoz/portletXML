package es.coritel.codington.festival.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.ISequencerDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class SequencerDAO implements ISequencerDAO {
	
	private Connection connection=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	private FERSDbQuery query = new FERSDbQuery();
	
	public SequencerDAO(){}
	
	public SequencerDAO (Connection conn){
		this.connection=conn;
	}

	@Override
	public int getNext(String classname) {
		// TODO Auto-generated method stub
		int result=0;
		
		try{
			st=connection.prepareStatement(query.getActualizaSequencer());
			st.setString(1, classname);
			st.executeUpdate();
			
			st=connection.prepareStatement(query.getSequencerActual());
			st.setString(1,classname);
			rs=st.executeQuery();
			rs.next();
			result=rs.getInt(1);
			
		}catch (SQLException e){
			result=-1;
			throw new DAOException(e.getMessage());
		}
		finally{
			FERSDataConnection.closeStatement(st);
		}
		return result;
	}

}

