package ir.freeland.jsonquize.service;

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
	
    

    // Private constructor to prevent instantiation
    private ConnectionManager() {
    }

    public static Connection getConnection() {
    	//@TODO create connection or return already available one
		return null;	
        
    }
}