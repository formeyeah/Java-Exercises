package ir.freeland.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	// JDBC URL, username and password of H2 server
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER = "sa"; // Default username
	private static final String PASSWORD = ""; // Default password (empty)

	public static void main(String[] args) {
		// Declare the connection and statement objects
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Establish the connection
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to the H2 database successfully!");

			// Create a statement object to execute queries
			statement = connection.createStatement();

			// Execute a SELECT query
			String sql = "SELECT * FROM COUNTRIES";
			resultSet = statement.executeQuery(sql);

			// Process the result set
			while (resultSet.next()) {
				String id = resultSet.getString("COUNTRY_ID");
				String name = resultSet.getString("COUNTRY_NAME");
				System.out.println("ID: " + id + ", Name: " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the resources
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}