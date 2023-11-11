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
            String selectQuery = "SELECT * FROM " + EQUIPMENTS_TABLE;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {

                int id = resultSet.getInt(ID_COLUMN);
                String name = resultSet.getString(NAME_COLUMN);
                String description = resultSet.getString(DESCRIPTION_COLUMN);
                Double daily_fee = resultSet.getDouble(DAILY_RENTAL_FEE_COLUMN);
                Double weekly_fee = resultSet.getDouble(WEEKLY_RENTAL_FEE_COLUMN);
                int category_id = resultSet.getInt(CATEGORY_ID_COLUMN);

                Equipment equipments = new Equipment(id, name, description, daily_fee, weekly_fee, category_id);

                FilmEquipments.add(equipments);

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
            String deleteQuery = "DELETE FROM equipments WHERE equipment_id = " + equipmentId;
            int rowsAffected = statement.executeUpdate(deleteQuery);
            if (rowsAffected > 0) {
                System.out.println("Deletion successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No equipment found with ID: " + equipmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

    public static void updateEquipment(int equipmentId, Equipment updatedEquipment) {
        Connection conn = AccessDatabaseConnector.connect();
        try (Statement statement = conn.createStatement()) {
            String updateQuery = "UPDATE FROM equipments ( daily_rental_fee, weekly_rental_fee) SET ('" + updatedEquipment.daily_fee + "', '" + updatedEquipment.weekly_fee + "');"
                    + "WHERE equipment_id = " + equipmentId;
            int rowsAffected = statement.executeUpdate(updateQuery);
            if (rowsAffected > 0) {
                System.out.println("Updated successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No equipment found with ID: " + equipmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

}
