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
public class EquipmentService {

    private static final String EQUIPMENTS_TABLE = "equipments";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String DAILY_RENTAL_FEE_COLUMN = "daily_rental_fee";
    private static final String WEEKLY_RENTAL_FEE_COLUMN = "weekly_rental_fee";
    private static final String CATEGORY_ID_COLUMN = "category_id";

    public static List getAllEquipments() {
        List<Equipment> FilmEquipments = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            // Execute a SELECT query
            String selectQuery = "SELECT " + EQUIPMENTS_TABLE + ".*, " + CategoryService.CATEGORIES_TABLE + ".name as category_name from " + EQUIPMENTS_TABLE + " left join " + CategoryService.CATEGORIES_TABLE + " ON " + EQUIPMENTS_TABLE + "." + CATEGORY_ID_COLUMN + "  = " + CategoryService.CATEGORIES_TABLE + "." + CategoryService.ID_COLUMN;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {

                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                String description = resultSet.getString(DESCRIPTION_COLUMN);
                Double daily_fee = resultSet.getDouble(DAILY_RENTAL_FEE_COLUMN);
                Double weekly_fee = resultSet.getDouble(WEEKLY_RENTAL_FEE_COLUMN);
                int category_id = resultSet.getInt(CATEGORY_ID_COLUMN);

                Equipment equipment = new Equipment(id, name, description, daily_fee, weekly_fee, category_id);
                Category category = new Category(category_id, resultSet.getString("category_name"));
                equipment.setCategory(category);

                FilmEquipments.add(equipment);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return FilmEquipments;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static void addEquipment(String name, String description, Double daily_rental_fee, Double weekly_rental_fee, int category_id) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query

                String insertQuery = "INSERT INTO " + EQUIPMENTS_TABLE + " (" + NAME_COLUMN + ", " + DESCRIPTION_COLUMN + ", " + DAILY_RENTAL_FEE_COLUMN + ", " + WEEKLY_RENTAL_FEE_COLUMN + ", " + CATEGORY_ID_COLUMN + ") VALUES ('" + name + "', '" + description + "', '" + daily_rental_fee + "', '" + weekly_rental_fee + "', '" + category_id + "');";
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
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

    public static void deleteEquipment(int equipmentId) {
        Connection conn = AccessDatabaseConnector.connect();
        try (Statement statement = conn.createStatement()) {
            String deleteQuery = "DELETE FROM " + EQUIPMENTS_TABLE + " WHERE " + ID_COLUMN + " = " + equipmentId;
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

    public static void updateEquipment(int equipmentId, String name, String description, Double daily_rental_fee, Double weekly_rental_fee, int category_id) {
        Connection conn = AccessDatabaseConnector.connect();
        try (Statement statement = conn.createStatement()) {
            String updateQuery = "Update " + EQUIPMENTS_TABLE + " SET " + NAME_COLUMN + " = '" + name + "', " + DESCRIPTION_COLUMN + " = '" + description + "', " + DAILY_RENTAL_FEE_COLUMN + " = '" + daily_rental_fee + "', " + WEEKLY_RENTAL_FEE_COLUMN + " = '" + weekly_rental_fee + "', " + CATEGORY_ID_COLUMN + " = '" + category_id + "' WHERE '" + ID_COLUMN + "' = " + "'" + equipmentId + "';";
            statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

}
