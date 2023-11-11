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

    private static final String ADMINS_TABLE = "admins";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String EMAIL_COLUMN = "email";
    private static final String USERNAME_COLUMN = "username";
    private static final String ADDRESS_COLUMN = "address";
    private static final String PHONE_NUMBER_COLUMN = "phone_number";
    private static final String PASSWORD_COLUMN = "password";

    public static Admin getByUsernameAndPassword(String username, String password) {
        String selectQuery = "SELECT * FROM " + ADMINS_TABLE + " WHERE " + USERNAME_COLUMN + " = '" + username + "' AND " + PASSWORD_COLUMN + " = '" + password + "' LIMIT 1;";

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            Admin admin = null;

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                String address = resultSet.getString(ADDRESS_COLUMN);
                String phone_number = resultSet.getString(PHONE_NUMBER_COLUMN);
                String admin_username = resultSet.getString(USERNAME_COLUMN);
                String admin_password = resultSet.getString(PASSWORD_COLUMN);

                admin = new Admin(id, name, email, address, phone_number, admin_username, admin_password);
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
            String selectQuery = "SELECT * FROM " + ADMINS_TABLE;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                String address = resultSet.getString(ADDRESS_COLUMN);
                String phone_number = resultSet.getString(PHONE_NUMBER_COLUMN);
                String username = resultSet.getString(USERNAME_COLUMN);
                String password = resultSet.getString(PASSWORD_COLUMN);

                Admin admin = new Admin(id, name, email, address, phone_number, username, password);

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
}
