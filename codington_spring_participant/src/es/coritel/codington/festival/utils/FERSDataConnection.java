package es.coritel.codington.festival.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import es.coritel.codington.festival.exceptions.DAOException;
/**
 * HELPER class to handle DATACONNECTIVITY with FESTIVALDATABASE in MYSQL
 */
public class FERSDataConnection {

	
	private static Connection  conn;
    //public FERSDataConnection(Connection conn2){}
	public FERSDataConnection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get connection
	 * @return
	 * @throws DAOException
	 */
//   public static Connection createConnection()throws DAOException{
//    	return conn;
//	}
//    
    
	
	
	public static Connection getConnection() throws DAOException {
		try {
    		String url = "jdbc:mysql://localhost/festivaldb";
    		String user = "root";
    		String pass = "abcd1234";
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection(url, user, pass);
    		System.out.println("Connection successfully established! \n");
    		conn.setAutoCommit(false);
    		//conn.close();

    		}catch(Exception e){
    			//System.out.println(e.getMessage());
    			throw new DAOException(e.getMessage());
    				
    		}	
    	return conn;
	}
	
	/**
	 * Close connection
	 * @param conn
	 * @throws DAOException
	 */
	public static void closeConnection(Connection conn) throws DAOException {
		try{
			conn.close();
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
	}
	
	
	/**
	 * Commit connection
	 * @param conn
	 * @throws DAOException
	 */
	public static void commit(Connection conn) throws DAOException {
		try{
			conn.commit();
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
	}
	//confirmar los cambios
	
	/**
	 * Rollback connection
	 * @param conn
	 * @throws DAOException
	 */
	public static void rollback(Connection conn) throws DAOException {
		try{
			conn.rollback();
		}catch (Exception e){
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Close preparedStatement
	 * @param ps
	 * @throws DAOException
	 */
	public static void closeStatement(PreparedStatement ps) throws DAOException {
	
		try{
		  ps.close();
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Close preparedStatement
	 * @param rs
	 * @throws DAOException
	 */
	public static void closeResulSet(ResultSet rs) throws DAOException {
		try{
			rs.close();
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
	}

}
