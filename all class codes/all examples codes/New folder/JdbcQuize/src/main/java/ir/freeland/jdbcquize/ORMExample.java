package ir.freeland.jdbcquize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ORMExample {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
    	String salary= "5000";
    	String sql = """
    			SELECT ???
    			FROM   ???
    			WHERE ????
    				   
    			""";
    	List<?> employees =null;
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        		PreparedStatement preparedStatement = connection.prepareStatement(sql);                
            ) {
                System.out.println("Connected to the H2 database successfully!");                
               //@TODO fill statement
                try(ResultSet resultSet = preparedStatement.executeQuery()){
	                // Process the result set
	                while (resultSet.next()) {
	                	//Build objects	                    
	                }
	                employees.forEach( System.out::println );
                }
            } 
        
        
    }
}