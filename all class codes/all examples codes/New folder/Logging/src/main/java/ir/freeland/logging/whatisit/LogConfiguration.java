package ir.freeland.logging.whatisit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogConfiguration {

	private static final Logger logger = Logger.getLogger(LogConfiguration.class.getName());
	
    public static void main(String[] args) throws SecurityException, FileNotFoundException, IOException {
    	 // Load logging properties from the specified file
    	LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));    	
        String filePath = "missing_file.txt"; // Ensure this file exists in the same directory

        readFile(filePath);
    }

    public static void readFile(String filePath) throws IOException {
        BufferedReader reader = null;

        try {
            // Attempt to create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader(filePath));
            logger.info("Successfull reading file");
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
            	logger.info("Reading a new line");
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
        	//logger.severe("Error: The file was not found. Please check the file path.");
        	logger.log(Level.SEVERE, "Error: The file was not found. Please check the file path.",e);
        } 
    }
}