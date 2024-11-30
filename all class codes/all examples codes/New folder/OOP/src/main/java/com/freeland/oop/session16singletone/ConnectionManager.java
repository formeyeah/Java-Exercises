package com.freeland.oop.session16singletone;

public class ConnectionManager {
    // The single instance of the class
    private static ConnectionManager instance;

    // Simulated database connection (for demonstration purposes)
    private String connectionString;

    // Private constructor to prevent instantiation from other classes
    private ConnectionManager() {
        // Initialize the connection string (simulated)
        connectionString = "jdbc:mysql://localhost:3306/mydatabase";
        // Here you would normally initialize the actual database connection
    }

    // Public method to provide access to the instance
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    // Example method to simulate getting a connection
    public void connect() {
        System.out.println("Connecting to the database using: " + connectionString);
        // Here you would normally implement actual connection logic
    }

    // Example method to simulate closing the connection
    public void disconnect() {
        System.out.println("Disconnecting from the database.");
        // Here you would normally implement actual disconnection logic
    }
}