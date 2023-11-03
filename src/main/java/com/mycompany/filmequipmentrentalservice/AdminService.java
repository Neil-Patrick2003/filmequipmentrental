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
public class AdminService {
    public static Admin getByUsernameAndPassword(String username, String password) {
        String selectQuery = "SELECT * FROM admins WHERE admin_user_name = '" + username + "' AND admin_password = '" + password + "' LIMIT 1;";

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            Admin admin = null;

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("admin_id");

                String name = resultSet.getString("admin_name");
                String email = resultSet.getString("admin_email");
                String address = resultSet.getString("admin_address");
                String phone_number = resultSet.getString("admin_phoneNumber");
                String admin_username = resultSet.getString("admin_user_name");
                String admin_password = resultSet.getString("admin_password");

                admin = new Admin(name, email, address, phone_number, admin_username, admin_password);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return admin;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }
    
    public static List getAllAdmins() {
        List<Admin> AdminList = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            // Execute a SELECT query
            String selectQuery = "SELECT * FROM admins";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("admin_id");

                String name = resultSet.getString("admin_name");
                String email = resultSet.getString("admin_email");
                String address = resultSet.getString("admin_address");
                String phone_number = resultSet.getString("admin_phoneNumber");
                String username = resultSet.getString("admin_user_name");
                String password = resultSet.getString("admin_password");

                Admin admin = new Admin(name, email, address, phone_number, username, password);

                AdminList.add(admin);

            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return AdminList;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;

    }

    public static void addAdmin(Admin admin) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT Into admins (admin_name, admin_email, admin_address, admin_phoneNumber, admin_user_name, admin_password) VALUES ('" + admin.name + "', '" + admin.email + "', '" + admin.address + "', '" + admin.phone_number + "', '" + admin.username + "', '" + admin.password + "');";
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
