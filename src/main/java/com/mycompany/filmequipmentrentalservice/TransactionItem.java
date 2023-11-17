/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

/**
 *
 * @author bryanmulingbayan
 */
public class TransactionItem {
    int equipment_id;
    int transaction_id;
    Double sub_total;
    Equipment equipment;

    public void setSubTotal(Double sub_total) {
        this.sub_total = sub_total;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        this.equipment_id = equipment.id;
    }
    
    
    
    
}
