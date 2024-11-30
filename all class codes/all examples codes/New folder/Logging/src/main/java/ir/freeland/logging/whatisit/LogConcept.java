package ir.freeland.logging.whatisit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConcept {

	private static final Logger logger = Logger.getLogger(LogConcept.class.getName());
	
    public static void main(String[] args) {
    	logger.setLevel(Level.SEVERE); // Set the logging level
    	logger.severe("This is a SEVERE message");
        logger.warning("This is a WARNING message");
        logger.info("This is an INFO message");
        logger.config("This is a CONFIG message");
        logger.fine("This is a FINE message");
        logger.finer("This is a FINER message");
        logger.finest("This is a FINEST message");
    }

    
}