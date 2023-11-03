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

    public static Customer getByUsernameAndPassword(String username, String password) {
        String selectQuery = "SELECT * FROM customers WHERE user_name = '" + username + "' AND password = '" + password + "' LIMIT 1;";

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            Customer customer = null;

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("customer_id");

                String customer_name = resultSet.getString("customer_name");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String user_name = resultSet.getString("user_name");
                String customer_password = resultSet.getString("password");
                String address = resultSet.getString("address");

                customer = new Customer(customer_name, email, phone_number, user_name, customer_password, address);
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
            String selectQuery = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("customer_id");

                String customer_name = resultSet.getString("customer_name");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String user_name = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");

                Customer customers = new Customer(customer_name, email, phone_number, user_name, password, address);

                CustomersList.add(customers);

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

    public static void addCustomers(Customer customers) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT Into customers (customer_name, email, phone_number, user_name, password, address ) VALUES ('" + customers.customer_name + "', '" + customers.email + "', '" + customers.phone_number + "', '" + customers.user_name + "', '" + customers.password + "', '" + customers.address + "');";
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
}
