package ir.freeland.jdbc.updateable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSet {
    // JDBC URL, username and password of H2 server
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/atestdb";
    private static final String USER = "sa"; // Default username
    private static final String PASSWORD = ""; // Default password (empty)

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement(
                		  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//See the types
                ResultSet updatableResultSet  = statement.executeQuery("SELECT * FROM COUNTRIES")
            ) {
                System.out.println("Connected to the H2 database successfully!");
                updatableResultSet .moveToInsertRow();
                updatableResultSet.updateString(1, "Afghanestan");
                updatableResultSet.updateString(2, "AF");
                updatableResultSet.updateString(3, "4");
                updatableResultSet.insertRow(); 

            } 
        
        
    }
}