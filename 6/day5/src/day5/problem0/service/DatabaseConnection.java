package day5.problem0.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//database in session5 folder
//1-list tamame karmandane department 1 -> eyne tamrine class 
//prepared statement ei bashe hard code nakonid toye code 
//2-list department hayi ke toye keshvar moshkhs hastan -> darbiarid 
//3-yedune karmand ezafe konid -> ba insert 
//4-ye berozresani anjam bede -> arjantin (ar) ro dar database update konid 
//ye table country dare msln ye keshvri AR hast ro argantineshso eshteba minvise , dastore update 


public class DatabaseConnection {
	
	private static final String URL= "jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";
	
	public static void main(String [] args) throws SQLException {

		String departmentID="1";
		String countryName="IRAN";
		
		
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
			System.out.println("connected to database");
			
					try (PreparedStatement preparedStatement = connection.prepareStatement(
							"SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=?")) {
						preparedStatement.setString(1, departmentID);
						
						
						
						ResultSet resultSet=preparedStatement.executeQuery();
						
						while (resultSet.next()) {
							String firstName=resultSet.getString("FIRST_NAME");
							String lastName=resultSet.getString("LAST_NAME");
							String email=resultSet.getString("EMAIL");
							System.out.printf("firstname %s last name %s email %s%n", firstName, lastName,email);
						}
					}
				
				try (PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT DEPARTMENT_NAME FROM DEPARTMENTS JOIN COUNTRIES " +
						 "ON COUNTRY_ID = COUNTRY_ID WHERE COUNTRY_NAME = ?")) {
					preparedStatement.setString(1, countryName);
					ResultSet resultSet=preparedStatement.executeQuery();
					System.out.println("connected to database getting department id(s)");
					while (resultSet.next()) {
						String nemidonam=resultSet.getString("DEPARTMENT_NAME");
						System.out.printf("department name: %s %n", nemidonam);
						
					}
				}
				
				try (PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO EMPLOYEES(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,MANAGER_ID,DEPARTMENT_ID)"+
				"VALUES (?,?,?,?,?,?,?,?,?,?)")) {
					preparedStatement.setString(1, "213");
					preparedStatement.setString(2, "rojina");
					preparedStatement.setString(3, "someone");
					preparedStatement.setString(4, "rojin@gmail.com");
					preparedStatement.setString(5, "09876");
					preparedStatement.setString(6, "2023-11-22");
					preparedStatement.setString(7, "8");
					preparedStatement.setString(8, "899999");
					preparedStatement.setString(9, "102");
					preparedStatement.setString(10, "2");
					
					int rowsChanged=preparedStatement.executeUpdate();
					System.out.println("rows changed"+ rowsChanged);
				}
				catch (SQLException e) {
					System.err.println("sth went wrong"+e);
				}
				
				//UPDATE table_name
			//	SET column1 = value1, column2 = value2, ...
			//			WHERE condition;

				try (PreparedStatement preparedStatement = connection.prepareStatement(
						
						"UPDATE COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_NAME = ?"
						)) {
					preparedStatement.setString(1, "GERMANY");
					preparedStatement.setString(2, "Germany");
					
					
					preparedStatement.executeUpdate();

				}
				
				

	
				
	
		}
		catch (SQLException e) {
			System.err.println("sth went wrong"+ e);
		}
		

				
				
				
				
				
		
		
		
		
		
	}

}
