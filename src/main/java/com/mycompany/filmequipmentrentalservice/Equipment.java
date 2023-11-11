/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

/**
 *
 * @author Neil Patrick
 */
public class Equipment {

    int id;
    String name;
    String description;
    Double daily_fee;
    Double weekly_fee;
    int category_id;

    public Equipment(int id, String name, String description, Double daily_fee, Double weekly_fee, int category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.daily_fee = daily_fee;
        this.weekly_fee = weekly_fee;
        this.category_id = category_id;

    }

}
