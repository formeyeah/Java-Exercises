package day5.sampleDatabase.inclass.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection3 {
	private static final String URL= "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
	public static void main(String[] main) throws SQLException {
		String departmentID="1";
		
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID= ?"))
		{
			
			System.out.println("connected to db");
			
			preparedStatement.setString(1, departmentID);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				String firstName=resultSet.getString("FIRST_NAME");
				System.out.println("firstName is"+ firstName);
			}
			

		}
		
		
		
		catch (SQLException e) {
			System.out.println(e);
			
		}
		
		
		
	}
	
	
	

}
