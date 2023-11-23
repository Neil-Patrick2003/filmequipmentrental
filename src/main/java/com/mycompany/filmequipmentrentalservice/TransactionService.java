/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Neil Patrick
 */
public class TransactionService {

    private static final String TRANSACTIONS_TABLE = "transactions";
    private static final String ID_COLUMN = "id";
    private static final String START_DATE_COLUMN = "start_date";
    private static final String END_DATE_COLUMN = "end_date";
    private static final String CUSTOMER_ID_COLUMN = "customer_id";
    private static final String STATUS_COLUMN = "status";
    private static final String TOTAL_COLUMN = "total";

    public static List getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            String selectQuery = "SELECT "
                    + "*, "
                    + "customers.name AS customer_name, "
                    + "customers.email AS customer_email, "
                    + "customers.username AS customer_username, "
                    + "customers.address AS customer_address, "
                    + "customers.phone_number AS customer_phone_number "
                    + "FROM transactions "
                    + "LEFT JOIN customers ON transactions.customer_id = customers.id ORDER by transactions.status DESC";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            // Process the results 
            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString(ID_COLUMN));
                Date startDate = dateFormatter.parse(resultSet.getString(START_DATE_COLUMN));
                Date endDate = dateFormatter.parse(resultSet.getString(END_DATE_COLUMN));
                int customerId = resultSet.getInt(CUSTOMER_ID_COLUMN);
                Double total = resultSet.getDouble(TOTAL_COLUMN);
                String status = resultSet.getString(STATUS_COLUMN);

                Transaction transaction = new Transaction(id, startDate, endDate, customerId, status, total, new ArrayList<TransactionItem>());
                Customer customer = new Customer(customerId, resultSet.getString("customer_name"), resultSet.getString("customer_name"), resultSet.getString("customer_phone_number"), resultSet.getString("customer_username"), "", resultSet.getString("customer_address"));
                transaction.setCustomer(customer);

                transactions.add(transaction);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return transactions;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static List getTransactionsByCustomerId(int customerId) {
        List<Transaction> transactions = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            String selectQuery = "SELECT "
                    + "*, "
                    + "customers.name AS customer_name, "
                    + "customers.email AS customer_email, "
                    + "customers.username AS customer_username, "
                    + "customers.address AS customer_address, "
                    + "customers.phone_number AS customer_phone_number "
                    + "FROM transactions "
                    + "LEFT JOIN customers ON transactions.customer_id = customers.id "
                    + "WHERE transactions.customer_id = '" + customerId + "' ORDER by transactions.status DESC";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            // Process the results 
            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString(ID_COLUMN));
                Date startDate = dateFormatter.parse(resultSet.getString(START_DATE_COLUMN));
                Date endDate = dateFormatter.parse(resultSet.getString(END_DATE_COLUMN));
                Double total = resultSet.getDouble(TOTAL_COLUMN);
                String status = resultSet.getString(STATUS_COLUMN);

                Transaction transaction = new Transaction(id, startDate, endDate, customerId, status, total, new ArrayList<TransactionItem>());
                Customer customer = new Customer(customerId, resultSet.getString("customer_name"), resultSet.getString("customer_name"), resultSet.getString("customer_phone_number"), resultSet.getString("customer_username"), "", resultSet.getString("customer_address"));
                transaction.setCustomer(customer);

                transactions.add(transaction);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return transactions;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static Transaction getTransactionsByTransactionId(UUID transactionId) {
        Transaction transaction = null;

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            String selectQuery = "SELECT "
                    + "*, "
                    + "customers.name AS customer_name, "
                    + "customers.email AS customer_email, "
                    + "customers.username AS customer_username, "
                    + "customers.address AS customer_address, "
                    + "customers.phone_number AS customer_phone_number "
                    + "FROM transactions "
                    + "LEFT JOIN customers ON transactions.customer_id = customers.id "
                    + "WHERE transactions.id = '" + transactionId.toString() + "' LIMIT 1";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            // Process the results 
            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString(ID_COLUMN));
                Date startDate = dateFormatter.parse(resultSet.getString(START_DATE_COLUMN));
                Date endDate = dateFormatter.parse(resultSet.getString(END_DATE_COLUMN));
                Double total = resultSet.getDouble(TOTAL_COLUMN);
                String status = resultSet.getString(STATUS_COLUMN);
                int customerId = resultSet.getInt(CUSTOMER_ID_COLUMN);

                transaction = new Transaction(id, startDate, endDate, customerId, status, total, new ArrayList<>());
                Customer customer = new Customer(customerId, resultSet.getString("customer_name"), resultSet.getString("customer_name"), resultSet.getString("customer_phone_number"), resultSet.getString("customer_username"), "", resultSet.getString("customer_address"));
                transaction.setCustomer(customer);

            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return transaction;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static void saveTransaction(Transaction transaction) {
        Connection conn = AccessDatabaseConnector.connect();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT INTO " + TRANSACTIONS_TABLE + " (" + ID_COLUMN + ", " + START_DATE_COLUMN + ", " + END_DATE_COLUMN + ", " + CUSTOMER_ID_COLUMN + ", " + STATUS_COLUMN + ", " + TOTAL_COLUMN + " ) VALUES ('" + transaction.id.toString() + "', '" + dateFormatter.format(transaction.startDate) + "', '" + dateFormatter.format(transaction.endDate) + "', '" + transaction.customer_id + "', '" + transaction.status + "', '" + transaction.total.toString() + "');";
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

    public static void updateTransactionStatus(String status, UUID id) {
        Connection conn = AccessDatabaseConnector.connect();
        try (Statement statement = conn.createStatement()) {
            String updateQuery = "Update " + TRANSACTIONS_TABLE + " SET " + STATUS_COLUMN + " = '" + status + "' WHERE " + ID_COLUMN + " = '" + id.toString() + "';";
            System.out.println(updateQuery);
            statement.executeUpdate(updateQuery);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }
}
