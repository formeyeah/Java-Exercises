package ir.freeland.exception.whatisit;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {

    public static void main(String[] args) {
        String filePath = "example.txt";

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
            
        } catch (IOException e) { //See the exception
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } 
    }
}