/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryanmulingbayan
 */
public class Cart {
    List<Equipment> equipments = new ArrayList<>();
    
    public void addItem(Equipment equipment) {
       this.equipments.add(equipment);
    }
    
    public void clearItems() {
      this.equipments.clear();
    }
    
    public void removeItem(int index) {
        this.equipments.remove(index);
    }
}
