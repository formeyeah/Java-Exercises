package ir.freeland.exception.whatisit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWithFinally {

    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to the path of your file

        // Call the method to read and print the file
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        BufferedReader reader = null;

        try {
            // Create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the reader in the finally block to ensure it gets closed
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}