/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Neil Patrick
 */
public class TransactionService {

    private static final String TRANSACTIONS_TABLE = "transactions";
    private static final String ID_COLUMN = "id";
    private static final String START_DATE_COLUMN = "start_date";
    private static final String END_DATE_COLUMN = "end_date";
    private static final String CUSTOMER_ID_COLUMNS = "customer_id";
    private static final String STATUS_COLUMN = "status";
    private static final String TOTAL_COLUMN = "total";

    public static void saveTransaction(Transaction transaction) {
        Connection conn = AccessDatabaseConnector.connect();
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  
        try {
            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT INTO " + TRANSACTIONS_TABLE + " (" + ID_COLUMN + ", " + START_DATE_COLUMN + ", " + END_DATE_COLUMN + ", " + CUSTOMER_ID_COLUMNS + ", " + STATUS_COLUMN + ", " + TOTAL_COLUMN + " ) VALUES ('" + transaction.id.toString() + "', '"  + dateFormatter.format(transaction.startDate) + "', '" + dateFormatter.format(transaction.endDate) + "', '" + transaction.customer_id + "', '" + transaction.status + "', '" + transaction.total.toString() + "');";
                System.out.println(insertQuery);
                int rowsAffected = statement.executeUpdate(insertQuery);
                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println("Insertion successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insertion failed.");
                }
            }
            System.err.println("");
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }
}
