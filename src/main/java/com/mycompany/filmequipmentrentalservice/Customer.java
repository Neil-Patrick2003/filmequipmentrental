/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

/**
 *
 * @author Neil Patrick
 */
public class Customer {

    int id;
    String name;
    String email;
    String phone_number;
    String username;
    String password;
    String address;

    public Customer(int id, String name, String email, String phone_number, String username, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        this.address = address;
    }
}
