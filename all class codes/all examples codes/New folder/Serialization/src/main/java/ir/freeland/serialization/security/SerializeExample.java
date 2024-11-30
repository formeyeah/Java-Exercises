package ir.freeland.serialization.security;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//1 . Saving an Object to a File: When you want to persist an object to a file for later retrieval.
//2 . Sending an Object Over a Network: When you need to transmit an object to another machine over a network (e.g., in RMI or web services).
//3 . Storing Objects in a Database: When you want to save the state of an object in a database.
public class SerializeExample {
    public static void main(String[] args) {
        User user = new User("Alice", "foo",30);

        try (FileOutputStream fileOut = new FileOutputStream("user.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(user);
            System.out.println("Serialized data is saved in user.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}