package ir.freeland.jsonquize.service;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.jsonquize.model.Employee;
import ir.freeland.jsonquize.service.exception.EmployeeServiceException;




	public class EmployeeService {
	private static final Logger log = Logger.getLogger(EmployeeService.class.getName());
	

	public static List<Employee> readAllEmployees(String fileName) throws EmployeeServiceException, StreamReadException, DatabindException, IOException {
		//@TODO read employee handle Exception and Log
		File file=new File("data-employees.json");
		List<Employee> employees=new ArrayList<>();
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			employees= objectMapper.readValue(file, new TypeReference <List<Employee>> (){});
			 
			
			
		} catch (DatabindException e) {
			log.severe("cant bind json file"+fileName);
			throw new EmployeeServiceException("cant bind data", e);
		}
		
		return employees;
	}
	

	public static int saveEmployee(List<Employee> employees) throws EmployeeServiceException {
		String sql ="""
    				INSERT INTO (FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,SALARY,JOB_ID,HIRE_DATE) VALUES
    				(?,?,?,?,?,1,CURRENT_DATE)
    				
				""";
		
		
		int rowsAffected = 0;
	 	try{
	 		PreparedStatement preparedStatement =  
		            ConnectionManager.getConnection().prepareStatement(sql);
	 		log.info("Connected to the H2 database successfully!");
	 		
            for (Employee emp : employees) {
            	//@TODO fill the statement
            	preparedStatement.setString(1, emp.getFirstName());
            	preparedStatement.setString(2, emp.getLastName());
            	preparedStatement.setString(3, emp.getEmail());
            	preparedStatement.setString(4, emp.getPhoneNumber());
            	preparedStatement.setString(5, emp.getSalary());
            	preparedStatement.executeUpdate();
            	rowsAffected++;
			}
            
	            
	    } catch (SQLException e) {
	    	throw new EmployeeServiceException("sth went wrong", e);
		
	   }
	return rowsAffected;
	}
		
}
