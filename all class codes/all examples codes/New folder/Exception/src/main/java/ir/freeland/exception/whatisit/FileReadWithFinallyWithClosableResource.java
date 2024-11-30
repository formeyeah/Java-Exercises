package ir.freeland.exception.whatisit;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReadWithFinallyWithClosableResource {

    public static void main(String[] args) {
        String filePath = "example.txt"; // Ensure this file exists in the same directory

        readFile(filePath);
    }

    public static void readFile(String filePath) {
        // Using try-with-resources to automatically close the resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }        
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        }
    }
}