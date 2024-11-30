package ir.freeland.jsonquize.service;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.jsonquize.model.Employee;
import ir.freeland.jsonquize.service.exception.EmployeeServiceException;

public class EmployeeService {
	private static final Logger log = Logger.getLogger(EmployeeService.class.getName());
	
	/**
	 * read a list of employees in json format
	 * @param fileName
	 * @return
	 * @throws EmployeeServiceException
	 */
	public static List<Employee> readAllEmployees(String fileName) throws EmployeeServiceException {
		//Open file		
		File file = new File(fileName);
		log.info("Reading file: " + fileName);
		
		ObjectMapper objectMapper = new ObjectMapper();		
		List<Employee> employees = new ArrayList<>();
		
		try {
			employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
		} catch (DatabindException e) {
			log.warning("Could not parse json. Check syntax of json file");
			throw new EmployeeServiceException("Databinding error",e);
		} catch (IOException e) {
			log.warning("Could not read file: " + fileName);
			throw new EmployeeServiceException("Employee file reader error",e);
		}
		log.info("Employees parsed :" + employees);
		
		return employees;
	}
	
	/**
	 * Save employees list in database. Database connection is set via @see ConnectionManager
	 * @param employees
	 * @return
	 * @throws EmployeeServiceException
	 */
	
	public static int saveEmployee(List<Employee> employees) throws EmployeeServiceException {
		String sql ="""
    				INSERT INTO employees(first_name,last_name,email,phone_number,salary,job_id,hire_date) 
    				VALUES (?,?,?,?,?,1,CURRENT_DATE)
				""";
		int rowsAffected = 0;
	 	try{
	 		PreparedStatement preparedStatement =  
		            ConnectionManager.getConnection().prepareStatement(sql);
	 		log.info("Connected to the H2 database successfully!");
	 		
            for (Employee emp : employees) {
            	log.info("Try inserting : " + emp.getEmail());
            	preparedStatement.setString(1, emp.getFirstName() ); 
	            preparedStatement.setString(2, emp.getLastName() );
	            preparedStatement.setString(3, emp.getEmail() );
	            preparedStatement.setString(4, emp.getPhoneNumber() );
	            preparedStatement.setString(5, emp.getSalary() );	            
	            preparedStatement.executeUpdate();
	            rowsAffected++;
	            log.info("Employee inserted. Total added rows : " + rowsAffected);
	            
			}
            
	            
	    } catch (SQLException e) {
			log.warning("Error in database opreation");
			throw new EmployeeServiceException("Database Error",e);
		
	   }
	return rowsAffected;
	}
		
}
