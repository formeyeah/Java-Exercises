package ir.freeland.exception.custom;

public class CustomExceptionMain {

    public static void main(String[] args) {
        // Test the age validation
    	//Use without catch and show compiler error.
    	//Describe catch or re-throw strategy
        try {
            AgeValidator.validateAge(20); // Valid age
            AgeValidator.validateAge(15); // Invalid age (too young)
            AgeValidator.validateAge(-5);  // Invalid age (negative)            
        } catch (InvalidAgeException e) {
            System.out.println("Validation error: " + e.getMessage());          
        } 
    }
}