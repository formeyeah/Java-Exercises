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
	

	public static List<Employee> readAllEmployees(String fileName) throws EmployeeServiceException {
		//@TODO read employee handle Exception and Log
		File file1 = new File(fileName);
		ObjectMapper objectmapper = new ObjectMapper();
		List<Employee> employee = new ArrayList<>();
		
		try {
			employee = objectmapper.readValue(file1, new TypeReference<List<Employee>>() {});
		
		} catch (DatabindException e) {
			log.severe("can not pars json check file" + fileName);
			throw new EmployeeServiceException("could not bind", e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	

	public static int saveEmployee(List<Employee> employees) throws EmployeeServiceException {
		String sql ="""
    				//@TODO insert
				""";
		int rowsAffected = 0;
	 	try{
	 		PreparedStatement preparedStatement =  
		            ConnectionManager.getConnection().prepareStatement(sql);
	 		log.info("Connected to the H2 database successfully!");
	 		
            for (Employee emp : employees) {
            	//@TODO fill the statment
	            
			}
            
	            
	    } catch (SQLException e) {
	    	//@TODO log and throw
		
	   }
	return rowsAffected;
	}
		
}
