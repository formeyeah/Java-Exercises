package ir.freeland.exception.whatisit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadMultiExceptionHandling {

    public static void main(String[] args) {
        String filePath = "example.txt"; // Ensure this file exists in the same directory

        readFile(filePath);
    }

    public static void readFile(String filePath) {
        BufferedReader reader = null;

        try {
            // Attempt to create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file was not found. Please check the file path.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while reading the file.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } 
    }
}