package ir.freeland.exception.whatisit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadMultiExceptionHandlingMultiCatch {

    public static void main(String[] args) {
        String filePath = "example.txt"; // Ensure this file exists in the same directory

        readFileAndParseNumber(filePath);
    }

    public static void readFileAndParseNumber(String filePath) {
        BufferedReader reader = null;

        try {
            // Attempt to create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                
                // Attempt to parse an integer from the line
                int number = Integer.parseInt(line);
                System.out.println("Parsed number: " + number);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            // Catch both FileNotFoundException and NumberFormatException
            System.out.println("Error: An error occurred while processing the file: " + e.getMessage());
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } catch (IOException e) {
            // Catch any other IOException that may occur
            System.out.println("Error: An I/O error occurred while reading the file.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.out.println("Error: An unexpected error occurred.");
            e.printStackTrace(); // Optional: Print the stack trace for debugging
        } finally {
            // Ensure the BufferedReader is closed
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error: An error occurred while closing the file.");
                e.printStackTrace(); // Optional: Print the stack trace for debugging
            }
        }
    }
}