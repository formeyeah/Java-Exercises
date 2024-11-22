package day5.sampleDatabase.inclass.jdbc.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	//define jdbc url, user,passwrod 
	private static final String URL="jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
	
	public static void main(String [] args) {
		Connection connection= null; 
		Statement statement=null;
		
		
		
		try {
			connection=DriverManager.getConnection(URL,USER,PASSWORD);
			statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("SELECT * FROM *");
			while (resultset.next()) {
				 String id=resultset.getString("COUNTRY_ID");
				 System.out.println("country id is:"+ id);
				
				
			}
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
	
}
