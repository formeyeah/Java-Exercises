package ir.freeland.jsonquize;

import java.io.FileInputStream;
import java.util.List;
import java.util.logging.LogManager;

import ir.freeland.jsonquize.model.Employee;
import ir.freeland.jsonquize.service.EmployeeService;

public class EmployeeApplication {
	
	private static final String DATA_EMPLOYEES_JSON = "data-employees.json";

	private static final String LOGGING_PROPERTIES = "logging.properties";

	public static void main(String[] args) throws Exception {
		//@TODO config logger "logging.properties"
		LogManager.getLogManager().readConfiguration(new FileInputStream(LOGGING_PROPERTIES));
		//@TODO call read from "data-employees.json" make it Constant
		List<Employee> employees=EmployeeService.readAllEmployees(DATA_EMPLOYEES_JSON);
		System.out.println(employees);
		//@TODO remove "+" from phone numbers
		employees.stream().filter(t -> t.getPhoneNumber().startsWith("+"))
		.forEach(t -> t.setPhoneNumber(t.getPhoneNumber().replace("+", "")));
		System.out.println(employees);
		//@TODO save
		int rowsAffected=EmployeeService.saveEmployee(employees);
		System.out.println(rowsAffected);
		
	}
}