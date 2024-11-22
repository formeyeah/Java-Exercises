package day5.sampleDatabase.inclass.jdbc.connection;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseconnection2 {
	private static final String URL= "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
	
	public static void main(String [] args) throws SQLException{
		String departmentID="1";
	
			 try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
					Statement statement = connection.createStatement();
					ResultSet resultset = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID= "+ departmentID))
			 { System.out.println("connected to database");
				while (resultset.next()) {
					System.err.println("came into loop");
					 String firstName=resultset.getString("FIRST_NAME");
					 System.out.println("firstname is:"+ firstName);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		

		
	}

		
	}
	

	

