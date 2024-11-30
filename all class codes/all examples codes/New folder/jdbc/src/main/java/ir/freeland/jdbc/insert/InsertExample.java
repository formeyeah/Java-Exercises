package ir.freeland.jdbc.insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {
        // Using try-with-resources to ensure resources are closed automatically
        try (
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = 
            		connection.prepareStatement(
            				"INSERT INTO COUNTRIES (COUNTRY_NAME, COUNTRY_ID, REGION_ID) VALUES (?, ?, ?)"
            				)
        ) {
            System.out.println("Connected to the H2 database successfully!");

            // Set the values for the prepared statement
            preparedStatement.setString(1, "IRANN"); // Set COUNTRY_NAME
            preparedStatement.setString(2, "IR"); // Set COUNTRY_ID
            preparedStatement.setString(3, "3"); // Set REGION_ID

            // Execute the insert operation
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the country table.");
        } 
    }
}