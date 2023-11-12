/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.List;
import javax.swing.*;
import org.apache.commons.lang.RandomStringUtils;

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

        System.out.println("Add new category");
        CategoryService.addCategory(RandomStringUtils.randomAlphanumeric(24));
        
        System.out.println("List of categories");
        List<Category> categories = CategoryService.getAllCategories();
        
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            System.out.println(category.name);
        }
        
        System.out.println("Add new equipment");
        EquipmentService.addEquipment(RandomStringUtils.randomAlphanumeric(24), RandomStringUtils.randomAlphanumeric(24), 1.0, 10.0, categories.getFirst().id);
        
        System.out.println("List of equipments");
        List<Equipment> equipments = EquipmentService.getAllEquipments();
        
        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            System.out.println(equipment.name);
        }
        
        System.out.println("Update equipment");
        EquipmentService.updateEquipment(equipments.getFirst().id, equipments.getFirst().name, equipments.getFirst().description, equipments.getFirst().daily_fee, equipments.getFirst().weekly_fee, equipments.getFirst().category_id);
        
        System.out.println("Delete equipment");
        EquipmentService.deleteEquipment(equipments.getFirst().id);
        
        System.out.println("List of customers");
        List<Customer> customers = CustomerService.getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println(customer.name);
        }
    }
}
