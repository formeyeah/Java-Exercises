package ir.freeland.jsonquize;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.LogManager;

import ir.freeland.jsonquize.model.Employee;
import ir.freeland.jsonquize.service.EmployeeService;

public class EmployeeApplication {
	
	private static final String LOGGING_PROPERTIES = "logging.properties";
	private static final String DATA_EMPLOYEES_JSON = "data-employees.json";

	public static void main(String[] args) throws Exception {
		LogManager.getLogManager().readConfiguration(new FileInputStream(LOGGING_PROPERTIES));
		
		//Fill list of employees
		List<Employee> employees = EmployeeService.readAllEmployees(DATA_EMPLOYEES_JSON);
		
		//remove "+" from phone numbers
		employees.forEach(emp -> emp.setPhoneNumber(  emp.getPhoneNumber().substring(1)  ));
		
		EmployeeService.saveEmployee (employees);
	}
}