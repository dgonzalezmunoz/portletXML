package es.coritel.codington.festival.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IVisitorDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;



public class VisitorDAO implements IVisitorDAO {
	
	private Connection connection=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	private FERSDbQuery query = new FERSDbQuery();
	//FERSDataConnection conexion;
	
	
    public VisitorDAO(){}
	
	public VisitorDAO (Connection conn){
		this.connection=conn;
	}
	
	@Override
	public boolean insertData(Visitor visitor) throws DAOException {
		// TODO Auto-generated method stub
		int res;
		try{
			st=connection.prepareStatement(query.getInsertVisitor());
			
			st.setInt(1, visitor.getVisitorId());
			st.setString(2,visitor.getUserName());
			st.setString(3, visitor.getPassword());
			st.setString(4,visitor.getFirstName());
			st.setString(5, visitor.getLastName());
			st.setString(6, visitor.getEmail());
			st.setString(7, visitor.getPhoneNumber());
			st.setString(8,visitor.getAddress());
			st.setString(9, visitor.getDni());

			res= st.executeUpdate();
			if(res>0)
				return true;
			else return false;
			
	 		
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
			//return false;
		}
	}
	
	
	//ResultSet rs = st.executeQuery
	@Override
	public Visitor searchUser(Visitor user) throws DAOException {
		
		Visitor v=null;
		try{
			st=connection.prepareStatement(query.getSearchVisitor());
			
			st.setString(1,user.getUserName());
			
			rs=st.executeQuery();
			
			while (rs.next()){
				v= new Visitor();
				v.setVisitorId(rs.getInt(1));
				v.setFirstName(rs.getString(2));
				v.setLastName(rs.getString(3));
				v.setDni(rs.getString(4));
				v.setEmail(rs.getString(5));
				v.setPhoneNumber(rs.getString(6));
				v.setAddress(rs.getString(7));
				v.setUserName(rs.getString(8));
				v.setPassword(rs.getString(9));
				v.setAdmin(rs.getBoolean(10));
				
			}return v;
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public int updateVisitor(Visitor visitor) throws DAOException {
		// TODO Auto-generated method stub
		int status=0;
		try{
			
			st=connection.prepareStatement(query.getUpdateVisitor());
			
			st.setString(1,visitor.getUserName());
			st.setString(2,visitor.getFirstName());
			st.setString(3, visitor.getLastName());
			st.setString(4, visitor.getEmail());
			st.setString(5, visitor.getPhoneNumber());
			st.setString(6,visitor.getAddress());
			st.setString(7, visitor.getDni());		
			st.setInt(8, visitor.getVisitorId());
			//st.setBoolean(9,visitor.isAdmin());
			
			status= st.executeUpdate();
			
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		
		return status;
	}

	@Override
	public int changePassword(Visitor visitor) throws DAOException {
		// TODO Auto-generated method stub
		int res;
		try{
			st=connection.prepareStatement(query.getChangePWDQuery());
			
			st.setString(1,visitor.getPassword());
			st.setInt(2, visitor.getVisitorId());
			
			res =st.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}
		return res;
	}

}
