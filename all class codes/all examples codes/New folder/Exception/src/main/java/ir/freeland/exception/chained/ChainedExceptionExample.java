package ir.freeland.exception.chained;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ChainedExceptionExample {

    public static void main(String[] args) {
        String filePath = "non_existent_file.txt"; // Change this to a valid path for testing

        try {
            readFile(filePath);
        } catch (CustomFileNotFoundException e) {
        	//See the double stack trace. Show how to read it from bottom to top
            System.out.println("Caught Custom Exception: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace of the custom exception
        }
    }

    public static void readFile(String filePath) throws CustomFileNotFoundException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Wrap the IOException in a CustomFileException
            throw new CustomFileNotFoundException("An I/O error occurred while reading the file.", e);
        } 
    }
}