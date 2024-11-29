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
	private static Connection connection;
	private static final String URL= "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
    

    // Private constructor to prevent instantiation
    private ConnectionManager() {
    }

    public static Connection getConnection() throws SQLException {
    	//@TODO create connection or return already available one
    	if (connection==null) {
			Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
			return connection;
			
		}
    	else {
    		return connection;
		}

        
    }
}