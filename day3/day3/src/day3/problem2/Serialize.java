package day3.problem2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
	
	public static void serializeUser(User user, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(user);
            System.out.println("User has been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }
		
		
	}

}
