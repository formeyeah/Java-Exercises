package ir.freeland.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionSQLInjection {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {
    	String depatmnetId="2"; //"2 OR 1=1"
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                		"SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = " + depatmnetId)
            ) {
                System.out.println("Connected to the H2 database successfully!");
                
                // Process the result set
                while (resultSet.next()) {
                	String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    System.out.println("FIRST_NAME: " + firstName + ", LAST_NAME: " + lastName);
                }
            } 
        
        
    }
}