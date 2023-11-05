/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.List;
import java.util.Scanner;
import java.awt.AWTEvent;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Neil Patrick
 */
public class FilmEquipmentRentalService {

    public static void main(String[] args) {
//        Login frame = new Login();
//        frame.setVisible(true);
        
        JFrame frame = new JFrame("Film Equipment Rental Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Login()); // Add the Login panel to the frame
        frame.pack(); // Resize the frame to fit the components
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
//        Scanner choiceScanner = new Scanner(System.in);
//        int userChoice;
//
//        System.out.println("1. Login as Customer");
//        System.out.println("2. Login as Admin");
//        userChoice = choiceScanner.nextInt();
//
//        switch (userChoice) {
//            case 1:
//                FilmEquipmentRentalService.loginAsCustomer();
//                break;
//
//            case 2:
//                FilmEquipmentRentalService.loginAsAdmin();
//                break;
//
//        }

//        System.out.println("1. Add Customers");
//        System.out.println("2. Add Equipments");
//        System.out.println("3. List Customers");
//        System.out.println("4. List Equipmetns");
//        System.out.println("5. Add Admins");
//        System.out.println("6. List Admin");
//        System.out.println("7. Delete Equipment");
//        System.out.println("0. Exit");
//        System.out.println("Enter CHoice:");
//        userChoice = choiceScanner.nextInt();
//
//        Scanner scanner = new Scanner(System.in);
//        switch (userChoice) {
//            case 1:
//                System.out.println("Adding Customer.\n");
//                System.out.println("Add Customer Name:");
//                String customer_name = scanner.nextLine();
//
//                System.out.println("Add Customer Email Address:");
//                String email = scanner.nextLine();
//
//                System.out.println("Add Customer Phone Number:");
//                String phone_number = scanner.nextLine();
//
//                System.out.println("Add User Name:");
//                String user_name = scanner.nextLine();
//
//                System.out.println("Add Customer Paswprd:");
//                String password = scanner.nextLine();
//
//                System.out.println("Add Customer Address:");
//                String address = scanner.nextLine();
//
//                Customer newCustomers = new Customer(customer_name, email, phone_number, user_name, password, address);
//                CustomerService.addCustomers(newCustomers);
//                break;
//
//            case 2:
//                System.out.println("Adding Equipment.");
//                System.out.println("Add Equipment Name");
//                String equipment_name = scanner.nextLine();
//
//                System.out.println("Add Equipment description");
//                String description = scanner.nextLine();
//
//                System.out.println("Add Hourly Rental Fee");
//                Double hourly_fee = scanner.nextDouble();
//
//                System.out.println("Add Daily Rental Fee");
//                Double daily_fee = scanner.nextDouble();
//
//                System.out.println("Add weekly Rental Fee");
//                Double weekly_fee = scanner.nextDouble();
//
//                System.out.println("Add Monthly Rental Fee");
//                Double monthly_fee = scanner.nextDouble();
//
//                System.out.println("Add category id");
//                int category_id = scanner.nextInt();
//
//                Equipment newEquipments = new Equipment(equipment_name, description, hourly_fee, daily_fee, weekly_fee, monthly_fee, category_id);
//                EquipmentService.addEquipments(newEquipments);
//
//                break;
//
//            case 3:
//                System.out.println("List of All Customers.");
//                List<Customer> CustomersList = CustomerService.getAllCustomers();
//
//                for (int i = 0; i < CustomersList.size(); i++) {
//                    Customer customers = CustomersList.get(i);
//                    System.out.println(customers.customer_name + "  " + customers.email);
//                }
//                break;
//
//            case 4:
//                System.out.println("List of All Equipments.");
//                List<Equipment> FilmEquipments = EquipmentService.getAllEquipments();
//
//                for (int i = 0; i < FilmEquipments.size(); i++) {
//                    Equipment equipments = FilmEquipments.get(i);
//                    System.out.println(equipments.equipment_name + "  " + equipments.description);
//                }
//                break;
//
//            case 5:
//                System.out.println("Adding Admin.");
//                System.out.println("Add Admin Name");
//                String admin_name = scanner.nextLine();
//
//                System.out.println("Add Admin Email Address");
//                String admin_email = scanner.nextLine();
//
//                System.out.println("Add Admin Address");
//                String admin_address = scanner.nextLine();
//
//                System.out.println("Add Admin Phone Number");
//                String admin_phoneNumber = scanner.nextLine();
//
//                System.out.println("Add Admin User Name");
//                String admin_user_name = scanner.nextLine();
//
//                System.out.println("Add Admin password");
//                String admin_password = scanner.nextLine();
//
//                Admin newAdmin = new Admin(admin_name, admin_email, admin_address, admin_phoneNumber, admin_user_name, admin_password);
//                AdminService.addAdmin(newAdmin);
//
//                break;
//
//            case 6:
//                System.out.println("List of All Equipments.");
//                List<Admin> AdminList = AdminService.getAllAdmins();
//
//                for (int i = 0; i < AdminList.size(); i++) {
//                    Admin admin = AdminList.get(i);
//                    System.out.println(admin.name + "  " + admin.email);
//                }
//                break;
//
//            case 7:
//                System.out.println("Deleting Equipments");
//                System.out.println("Enter Equipment id to delete:");
//                int equipment_id = scanner.nextInt();
//
//                EquipmentService.deleteEquipment(equipment_id);
//
////            case 8:
////                System.out.println("Updating Equipments");
////                System.out.println("Enter Equipment id to update:");
////                int equipment_to_update_id = scanner.nextInt();
////                
////                System.out.println("Updated hourly rental fee");
////                Double updatedHourlyFEE = scanner.nextDouble();
////
////                System.out.println("Add Admin Email Address");
////                Double updatedDailyFEE = scanner.nextDouble();
////
////                System.out.println("Add Admin Address");
////                Double updatedWeeklyFEE = scanner.nextDouble();
////
////                System.out.println("Add Admin Phone Number");
////                Double updatedMonthlyFEE = scanner.nextDouble();
////               
////                Equipments updatedEquipment = new Equipments(updatedEquipment.equipment_name, updatedEquipment.description, updatedHourlyFee, updatedDailyFee, updatedWeeklyFee, updatedMonthlyFee, 0);
//////               Equipments newEquipment = new Equipments(null, null, updatedEquipment.daily_fee, updatedEquipment.daily_fee, updatedEquipment.weekly_fee, updatedEquipment.monthly_fee, 0); 
////               Equipments.updateEquipment(equipment_id, updatedEquipment);
////                
//            case 0:
//                System.out.println("Exiting program....");
//                break;
//        }
//    }

//    public static void loginAsCustomer() {
//        int choice = 0;
//        Scanner choiceScanner = new Scanner(System.in);
//
//        System.out.println("Welcome Customer");
//
//        Customer customer;
//
//        do {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter Username");
//           String username = scanner.nextLine();
//
//            System.out.println("Enter password");
//            String password = scanner.nextLine();
//
//            customer = CustomerService.getByUsernameAndPassword(username, password);
//
//            if (customer != null) {
//                System.out.println("Successfully login as: " + customer.customer_name);
//            } else {
//                System.out.println("Invalid credentials");
//                System.out.println("1. Try again");
//                System.out.println("2. Exit");
//                choice = choiceScanner.nextInt();
//            }
//
//        } while (customer == null && choice != 2);
//
//    }
//
//    public static void loginAsAdmin() {
//        int choice = 0;
//        Scanner choiceScanner = new Scanner(System.in);
//
//        System.out.println("Welcome Admin");
//
//        Admin admin;
//
//        do {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter Username:");
//            String username = scanner.nextLine();
//
//            System.out.println("Enter password");
//            String password = scanner.nextLine();
//
//            admin = AdminService.getByUsernameAndPassword(username, password);
//
//            if (admin != null) {
//                System.out.println("Successfully login as: " + admin.name);
//            } else {
//                System.out.println("Invalid credentials");
//                System.out.println("1. Try again");
//                System.out.println("2. Exit");
//                choice = choiceScanner.nextInt();
//            }
//
//        } while (admin == null && choice != 2);
//    }
//}
