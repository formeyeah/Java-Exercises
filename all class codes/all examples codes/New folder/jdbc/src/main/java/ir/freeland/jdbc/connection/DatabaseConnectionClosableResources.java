package ir.freeland.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionClosableResources {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM COUNTRIES")
            ) {
                System.out.println("Connected to the H2 database successfully!");
                
                // Process the result set
                while (resultSet.next()) {
                	String id = resultSet.getString("COUNTRY_ID");
                    String name = resultSet.getString("COUNTRY_NAME");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            } 
        
        
    }
}