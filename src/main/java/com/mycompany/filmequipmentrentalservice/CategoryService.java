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
public class CategoryService {

    public static final String CATEGORIES_TABLE = "categories";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    public static void addCategory(String name) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT INTO " + CATEGORIES_TABLE + " (" + NAME_COLUMN + ") VALUES ('" + name + "');";

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

    public static List getAllCategories() {
        List<Category> categories = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            // Execute a SELECT query
            String selectQuery = "SELECT * FROM " + CATEGORIES_TABLE;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                Category category = new Category(id, name);
                categories.add(category);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return categories;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

 public static Category getCategoryByName(String name) {
        String selectQuery = "SELECT * FROM " + CATEGORIES_TABLE + " WHERE " + NAME_COLUMN + " = '" + name + "' LIMIT 1;";

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            Category category = null;

            // Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt(ID_COLUMN);
                category = new Category(id, name);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return category;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }
}
