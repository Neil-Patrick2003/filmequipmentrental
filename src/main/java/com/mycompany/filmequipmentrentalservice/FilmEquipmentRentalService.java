/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.List;
import javax.swing.*;

/**
 *
 * @author Neil Patrick
 */
public class FilmEquipmentRentalService {

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Film Equipment Rental Service");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new StartingPage()); // Add the Login panel to the frame
//        frame.pack(); // Resize the frame to fit the components
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);

        System.out.println("List of categories");
        List<Category> categories = CategoryService.getAllCategories();

        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            System.out.println(category.name);
        }

        System.out.println("List of equipments");
        List<Equipment> equipments = EquipmentService.getAllEquipments();

        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            System.out.println(equipment.name);
        }

        System.out.println("List of customers");
        List<Customer> customers = CustomerService.getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println(customer.name);
        }
    }
}
