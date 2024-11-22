package day5.sampleDatabase.inclass.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection4 {
	private static final String URL= "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
	public static void main(String[] args) {

		
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO COUNTRIES (COUNTRY_NAME, COUNTRY_ID, REGION_ID)" +" VALUES (?,?,?)")
						)
		{
			
			System.out.println("connected to db");
			
			preparedStatement.setString(1, "IRAN");
			preparedStatement.setString(2, "IR");
			preparedStatement.setString(3, "3");
			
			int rowsaffected=preparedStatement.executeUpdate();
			System.out.println("rowsAffected" + rowsaffected);
		}
		
		
		
		catch (SQLException e) {
			System.out.println(e);
			
		}
		
		
		
		
		
		
		

	}

}
