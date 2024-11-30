package ir.freeland.jsondatabasesequrity.quize.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Utility for connection to database
 * @author A_Fattahi
 */
public class ConnectionManager{
	private static final Logger log = Logger.getLogger(ConnectionManager.class.getName());

	  private static Connection connection;

	    // Private constructor to prevent instantiation
	    private ConnectionManager() {
	    }

	    public static Connection getConnection() {
	        if (connection == null) {
	            try {
	                connection = 
	                		DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USER, DatabaseInfo.PASSWORD);
	            } catch (SQLException e) {
	            	log.severe("Database connection Error");
	            	throw new RuntimeException("Employee file reader error",e);
	            }
	        }
	        return connection;
	    }
}