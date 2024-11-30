package ir.freeland.exception.custom;

public class AgeValidator {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        }
        if (age < 18) {
            throw new InvalidAgeException("You must be at least 18 years old.");
        }
        System.out.println("Age is valid: " + age);
    }
}
