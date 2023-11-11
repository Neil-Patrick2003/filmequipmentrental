/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Neil Patrick
 */
public class Equipment {

    
    int equipment_id;
    String equipment_name;
    String description;
    
    Double daily_fee;
    Double weekly_fee;
    
    int category_id;

    public Equipment(int equipment_id, String equipment_name, String description, Double daily_fee, Double weekly_fee, int category_id)  {
        this.equipment_name = equipment_name;
        this.description = description;
        this.daily_fee = daily_fee;
        this.weekly_fee = weekly_fee;
        this.category_id = category_id;
        this.equipment_id = equipment_id;
       
    }

}
