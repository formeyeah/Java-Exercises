package com.freeland.oop.session16singletone;

public class UseSingletone {
    public static void main(String[] args) {
        // Get the only instance of ConnectionManager
        ConnectionManager connectionManager = ConnectionManager.getInstance();

        // Connect to the database
        connectionManager.connect();

        // Perform database operations here (simulated)
        
        // Disconnect from the database
        connectionManager.disconnect();

        // Verify that only one instance exists
        ConnectionManager anotherConnectionManager = ConnectionManager.getInstance();
        System.out.println("Are both instances the same? " + (connectionManager == anotherConnectionManager));
    }
}