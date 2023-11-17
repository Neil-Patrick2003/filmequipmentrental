/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Neil Patrick
 */
public class TransactionItemService {

    private static final String TRANSACTION_ITEMS_TABLE = "transaction_items";
    private static final String ID_COLUMN = "id";
    private static final String TRANSACTION_ID_COLUMN = "transaction_id";
    private static final String EQUIPMENT_ID_COLUMN = "equipment_id";
    private static final String SUB_TOTAL_COLUMN = "sub_total";

    public static void saveTransactionItems(List<TransactionItem> transactionItems) {
        Connection conn = AccessDatabaseConnector.connect();

        String insertQuery = "INSERT INTO " + TRANSACTION_ITEMS_TABLE + "(" + ID_COLUMN + ", " + TRANSACTION_ID_COLUMN + ", " + EQUIPMENT_ID_COLUMN + ", " + SUB_TOTAL_COLUMN + ") VALUES ";

        for (int i = 0; i < transactionItems.size(); i++) {
            TransactionItem item = transactionItems.get(i);
            insertQuery = insertQuery + "('" + item.id.toString() + "', '" + item.transaction_id.toString() + "', '" + item.equipment_id + "', '" + item.sub_total.toString() + "')";

            insertQuery = i == transactionItems.size() - 1 ? insertQuery + ";" : ",";
        }
        
        System.out.println(insertQuery);

        try {
            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
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
