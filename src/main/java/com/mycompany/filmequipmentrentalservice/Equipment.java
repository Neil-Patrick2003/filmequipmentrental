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
    Category category;
    boolean is_available;
    String status;

    public Equipment(int id, String name, String description, Double daily_fee, Double weekly_fee, int category_id, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.daily_fee = daily_fee;
        this.weekly_fee = weekly_fee;
        this.category_id = category_id;
        this.is_available = true;
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    

    public void setIsAvailable(boolean is_available) {
        this.is_available = is_available;
    }
    
    public String getIsAvailableText(){
        if(is_available){
            return "Available";
        }
        else{
            return "Not Available";
        }
    }
}
