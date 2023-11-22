/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neil Patrick
 */
public class CustomerService {

    private static final String CUSTOMERS_TABLE = "customers";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String EMAIL_COLUMN = "email";
    private static final String USERNAME_COLUMN = "username";
    private static final String ADDRESS_COLUMN = "address";
    private static final String PHONE_NUMBER_COLUMN = "phone_number";
    private static final String PASSWORD_COLUMN = "password";

    public static Customer getByUsernameAndPassword(String username, String password) {
        String selectQuery = "SELECT * FROM " + CUSTOMERS_TABLE + " WHERE " + USERNAME_COLUMN + " = '" + username + "' AND " + PASSWORD_COLUMN + " = '" + password + "' LIMIT 1;";

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            Customer customer = null;

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt(ID_COLUMN);

                String name = resultSet.getString(NAME_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                String phone_number = resultSet.getString(PHONE_NUMBER_COLUMN);
                String address = resultSet.getString(ADDRESS_COLUMN);

                customer = new Customer(id, name, email, phone_number, username, password, address);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return customer;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static List getAllCustomers() {
        List<Customer> CustomersList = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            // Execute a SELECT query
            String selectQuery = "SELECT * FROM " + CUSTOMERS_TABLE;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt(ID_COLUMN);

                String name = resultSet.getString(NAME_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                String phone_number = resultSet.getString(PHONE_NUMBER_COLUMN);
                String username = resultSet.getString(USERNAME_COLUMN);
                String password = resultSet.getString(PASSWORD_COLUMN);

                String address = resultSet.getString(ADDRESS_COLUMN);

                Customer customer = new Customer(id, name, email, phone_number, username, password, address);

                CustomersList.add(customer);

            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return CustomersList;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static void addCustomer(String name, String email, String phone_number, String username, String password, String address) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT INTO " + CUSTOMERS_TABLE + " (" + NAME_COLUMN + ", " + EMAIL_COLUMN + ", " + PHONE_NUMBER_COLUMN + ", " + USERNAME_COLUMN + ", " + PASSWORD_COLUMN + ", " + ADDRESS_COLUMN + " ) VALUES ('" + name + "', '" + email + "', '" + phone_number + "', '" + username + "', '" + password + "', '" + address + "');";
                System.out.println(insertQuery);
                int rowsAffected = statement.executeUpdate(insertQuery);
                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println("Insertion successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insertion failed.");
                }
                // Close the statement
            }
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

    public static void updateCustomer(int id, String name, String email, String phone_number, String username, String address) {
        Connection conn = AccessDatabaseConnector.connect();
        try (Statement statement = conn.createStatement()) {
            String updateQuery = "Update " + CUSTOMERS_TABLE + " SET " + NAME_COLUMN + " = '" + name + "', " + EMAIL_COLUMN + " = '" + email + "', " + PHONE_NUMBER_COLUMN + " = '" + phone_number + "', " + USERNAME_COLUMN + " = '" + username + "', " + ADDRESS_COLUMN + " = '" + address  +  "' WHERE " + ID_COLUMN + " = " + id + ";";
            System.out.println(updateQuery);
            statement.executeUpdate(updateQuery);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }
}
