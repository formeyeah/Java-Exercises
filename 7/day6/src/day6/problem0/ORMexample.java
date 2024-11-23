package day6.problem0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ORMexample {
	
	
	// tamrin: eyne kari ke sre clss kardim : fehreste edare hayi ke dar keshvare x hastan, 
	//→ parameter begiri, arganitine va amerika, esm keshvar, esm edare, bargardoni va print koni

	//chizi ke barmigrdni esm keshvar va esm edare hast: 

	//ye table department dari va ye table country dari :
	
	private static final String URL="jdbc:h2:tcp://localhost:9092/~/atestdb";
	private static final String USER="sa";
	private static final String PASSWORD="";

	public static void main(String[] args) throws SQLException {
		String country="United States of America";
		String SQLcommand=""" 
	SELECT DEPARTMENTS.DEPARTMENT_NAME, COUNTRIES.COUNTRY_NAME
	FROM DEPARTMENTS
	JOIN LOCATIONS ON DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID
	JOIN COUNTRIES ON LOCATIONS.COUNTRY_ID = COUNTRIES.COUNTRY_ID
	WHERE COUNTRIES.COUNTRY_NAME = ?


				""";
		List<Department> departments=new ArrayList<>();
		
		 try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SQLcommand)) {
			 preparedStatement.setString(1, country);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
							Department department=new Department();
							department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
							Country countryObject=new Country();
							countryObject.setCountryName(resultSet.getString("COUNTRY_NAME"));
							department.setDepartmentCountry(countryObject);
							departments.add(department);
							
				}
			}
		}
				departments.forEach( System.out::println );
		
		

	}

}
