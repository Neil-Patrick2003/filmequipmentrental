/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Neil Patrick
 */
public class AccessDatabaseConnector {
    // JDBC URL, username, and password of the database to connect
    private static final String URL = "jdbc:ucanaccess://C://Users//Neil Patrick//OneDrive//Documents//Film Equipment Rental Service.accdb";
    
    // Method to establish a connection to the Access database
    public static Connection connect() {
        Connection connection = null;
        try {
            // Establish a connection
            connection = DriverManager.getConnection(URL);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            // Handle any errors
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        return connection;
    }
    
    // Method to close the database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            // Handle any errors
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }    
}
