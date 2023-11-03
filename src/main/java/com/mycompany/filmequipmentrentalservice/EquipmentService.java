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
    
    public static List getAllEquipments() {
        List<Equipment> FilmEquipments = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            // Execute a SELECT query
            String selectQuery = "SELECT * FROM equipments";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("equipment_id");

                String equipment_name = resultSet.getString("equipment_name");
                String description = resultSet.getString("description");
                Double hourly_fee = resultSet.getDouble("hourly_rental_fee");
                Double daily_fee = resultSet.getDouble("daily_rental_fee");
                Double weekly_fee = resultSet.getDouble("weekly_rental_fee");
                Double monthly_fee = resultSet.getDouble("monthly_rental_fee");
                int category_id = resultSet.getInt("category_id");

                Equipment equipments = new Equipment(equipment_name, description, hourly_fee, daily_fee, weekly_fee, monthly_fee, category_id);

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

    public static void addEquipments(Equipment equipments) {
        Connection conn = AccessDatabaseConnector.connect();
        try {

            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                // Execute an INSERT query
                String insertQuery = "INSERT Into equipments (equipment_name, description, hourly_rental_fee, daily_rental_fee, weekly_rental_fee, monthly_rental_fee, category_id) VALUES ('" + equipments.equipment_name + "', '" + equipments.description + "', '" + equipments.hourly_fee + "', '" + equipments.daily_fee + "', '" + equipments.weekly_fee + "', '" + equipments.monthly_fee + "', '" + equipments.category_id + "');";
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
            String updateQuery = "UPDATE FROM equipments (hourly_rental_fee, daily_rental_fee, weekly_rental_fee, monthly_rental_fee) SET ('" + updatedEquipment.hourly_fee + "', '" + updatedEquipment.daily_fee + "', '" + updatedEquipment.weekly_fee + "', '" + updatedEquipment.monthly_fee + "');"
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
