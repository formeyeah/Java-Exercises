package ir.freeland.jdbcquize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ORMExample {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
    	String salary= "5000";
    	String sql = """
    			SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,SALARY,DEPARTMENTS.DEPARTMENT_NAME
    			FROM   EMPLOYEES,DEPARTMENTS
    			WHERE 
    				   EMPLOYEES.DEPARTMENT_ID=DEPARTMENTS.DEPARTMENT_ID 
    				   AND
    				   SALARY > ?
    			""";
    	List <Employee> employees = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        		PreparedStatement preparedStatement = connection.prepareStatement(sql);                
            ) {
                System.out.println("Connected to the H2 database successfully!");                
                preparedStatement.setString(1, salary);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
	                // Process the result set
	                while (resultSet.next()) {
                	
	                	Employee employee = new Employee();
	                	employee.setId( resultSet.getString("EMPLOYEE_ID") );
	                	employee.setEmail( resultSet.getString("EMAIL") );
	                	employee.setFirstName( resultSet.getString("FIRST_NAME") );
	                	employee.setLastName ( resultSet.getString("LAST_NAME") );
	                	employee.setSalary( resultSet.getString("SALARY") );
	                	
	                	Department department = new Department();
	                	department.setName( resultSet.getString("DEPARTMENT_NAME") );
	                	employee.setDepartment(department);
	                	employees.add(employee);	                    
	                }
	                employees.forEach( System.out::println );
                }
            } 
        
        
    }
}