/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import static com.mycompany.filmequipmentrentalservice.CategoryService.CATEGORIES_TABLE;
import static com.mycompany.filmequipmentrentalservice.CategoryService.NAME_COLUMN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public static List getTransactionItemsByTransactionId(UUID transactionId) {
        List<TransactionItem> items = new ArrayList<>();

        Connection conn = AccessDatabaseConnector.connect();
        try {
            Statement statement = conn.createStatement();

            String selectQuery = "SELECT "
                    + "transaction_items.*, "
                    + "equipments.name as equipment_name, "
                    + "equipments.description as equipment_description, "
                    + "equipments.category_id as equipment_category_id, "
                    + "equipments.daily_rental_fee as equipment_daily_rental_fee, "
                    + "equipments.weekly_rental_fee as equipment_weekly_rental_fee, "
                    + "equipments.status as equipment_status "
                    + "FROM "
                    + "transaction_items "
                    + "LEFT JOIN equipments ON transaction_items.equipment_id = equipments.id "
                    + "WHERE transaction_id = '" + transactionId.toString() + "';";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            // Process the results
            while (resultSet.next()) {

                UUID id = UUID.fromString(resultSet.getString(ID_COLUMN));
                int equipmentId = resultSet.getInt(EQUIPMENT_ID_COLUMN);
                Double subTotal = resultSet.getDouble(SUB_TOTAL_COLUMN);

//                int id, String name, String description, Double daily_fee, Double weekly_fee, int category_id
                String equipmentName = resultSet.getString("equipment_name");
                String equipmentDescription = resultSet.getString("equipment_description");
                Double equipmentDailyRental = resultSet.getDouble("equipment_daily_rental_fee");
                Double equipmentWeeklyRental = resultSet.getDouble("equipment_daily_rental_fee");
                int equipmentCategoryId = resultSet.getInt("equipment_category_id");
                String status = resultSet.getString("equipment_status");

                TransactionItem item = new TransactionItem(id, transactionId, equipmentId, subTotal);
                Equipment equipment = new Equipment(equipmentId, equipmentName, equipmentDescription, equipmentDailyRental, equipmentWeeklyRental, equipmentCategoryId, status);
                item.setEquipment(equipment);

                items.add(item);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();

            return items;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }

        return null;
    }

    public static void saveTransactionItems(List<TransactionItem> transactionItems) {
        Connection conn = AccessDatabaseConnector.connect();

        String insertQuery = "INSERT INTO " + TRANSACTION_ITEMS_TABLE + "(" + ID_COLUMN + ", " + TRANSACTION_ID_COLUMN + ", " + EQUIPMENT_ID_COLUMN + ", " + SUB_TOTAL_COLUMN + ") VALUES ";

        for (int i = 0; i < transactionItems.size(); i++) {
            TransactionItem item = transactionItems.get(i);
            insertQuery = insertQuery + "('" + item.id.toString() + "', '" + item.transaction_id.toString() + "', '" + item.equipment_id + "', '" + item.sub_total.toString() + "')";

            insertQuery = i == transactionItems.size() - 1 ? insertQuery + ";" : ",";
        }
        System.out.println("HAHAHAHAH");
        System.out.println(transactionItems.size());
        System.out.println(insertQuery);

        try {
            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(insertQuery);
            }
            System.err.println("");
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }

    public static void saveTransactionItem(TransactionItem item) {
        Connection conn = AccessDatabaseConnector.connect();

        String insertQuery = "INSERT INTO " + TRANSACTION_ITEMS_TABLE + "(" + ID_COLUMN + ", " + TRANSACTION_ID_COLUMN + ", " + EQUIPMENT_ID_COLUMN + ", " + SUB_TOTAL_COLUMN + ") VALUES ";

        insertQuery = insertQuery + "('" + item.id.toString() + "', '" + item.transaction_id.toString() + "', '" + item.equipment_id + "', '" + item.sub_total.toString() + "');";

        System.out.println(insertQuery);

        try {
            // Execute an INSERT query
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(insertQuery);
            }
            System.err.println("");
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            AccessDatabaseConnector.closeConnection(conn);
        }
    }
}
