package ir.freeland.jdbc.updateable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetAndBatch {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);        		
                Statement statement = connection.createStatement(
                		  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet  = statement.executeQuery("SELECT * FROM EMPLOYEES");
            ) {

	        	while (resultSet.next()) {
	                // Print current employee data
	                int id = resultSet.getInt("EMPLOYEE_ID");
	                String name = resultSet.getString("FIRST_NAME");
	                double salary = resultSet.getDouble("SALARY");
	                System.out.println("Before Update - ID: " + id + ", Name: " + name + ", Salary: " + salary);
	
	                // Update the salary (for demonstration, increase it by 10%)
	                double newSalary = salary * 1.10;
	                resultSet.updateDouble("SALARY", newSalary);
	                resultSet.updateRow(); // Apply the update to the database
	            }
	        	
            }
        
        
    }
}