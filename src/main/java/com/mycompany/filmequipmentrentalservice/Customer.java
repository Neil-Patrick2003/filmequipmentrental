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
public class Customer {

    String customer_name;
    String email;
    String phone_number;
    String user_name;
    String password;
    String address;

    public Customer(String customer_name, String email, String phone_number, String user_name, String password, String address) {
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
        this.user_name = user_name;
        this.password = password;
        this.address = address;
    }
}
