package ir.freeland.jsonquize;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.LogManager;

import ir.freeland.jsonquize.model.Employee;
import ir.freeland.jsonquize.service.EmployeeService;

public class EmployeeApplication {
	
	private static final String DATA_EMPLOYEES_JSON = "data-employees.json";
	private static final String LOGGING_PROPERTIES = "logging.properties";
	//private static final String LOGGING_PROPERTIES = "logging.properties";
	//private static final String Data_EMPLOYEES_JSON = "data-employees.json";

	public static void main(String[] args) throws Exception {
		//@TODO config logger "logging.properties"
		LogManager.getLogManager().readConfiguration(new FileInputStream(LOGGING_PROPERTIES) );
		List<Employee> employee = EmployeeService.readAllEmployees(DATA_EMPLOYEES_JSON);
		//@TODO call read from "data-employees.json" make it Constant
		employee.forEach(t ->t.setPhoneNumber(t.getPhoneNumber().substring(1)));
		EmployeeService.saveEmployee(employee);
	
		//@TODO remove "+" from phone numbers

		//@TODO save
		
	}
}