/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neil Patrick
 */
public class Admin {

    int id;
    String name;
    String email;
    String address;
    String phone_number;
    String username;
    String password; 

    public Admin(int id, String name, String email, String address, String phone_number, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

}
