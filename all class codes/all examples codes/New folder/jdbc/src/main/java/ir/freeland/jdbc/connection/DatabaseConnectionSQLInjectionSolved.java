package ir.freeland.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionSQLInjectionSolved {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {
    	String depatmnetId="2 OR 1=1"; //Evil input
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        		PreparedStatement preparedStatement = connection.prepareStatement(
        				"SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ?");                
            ) {
                System.out.println("Connected to the H2 database successfully!");                
                preparedStatement.setString(1, depatmnetId);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
	                // Process the result set
	                while (resultSet.next()) {
	                	String firstName = resultSet.getString("FIRST_NAME");
	                    String lastName = resultSet.getString("LAST_NAME");
	                    System.out.println("FIRST_NAME: " + firstName + ", LAST_NAME: " + lastName);
	                }
                }
            } 
        
        
    }
}