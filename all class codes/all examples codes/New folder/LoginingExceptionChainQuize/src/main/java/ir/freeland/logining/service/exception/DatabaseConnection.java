package ir.freeland.logining.service.exception;

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
			connection = DriverManager. getConnection (URL, USER, PASSWORD);
			System.out.println("connected to the H2 database successfully!");
			 statement= connection.createStatement();
			 String sq1 = "SELECT * FROM COUNTRIES";
			 resultSet = statement.executeQuery(sq1);
			 
while (resultSet.next()) {
String r1= resultSet.getString("county_name");

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