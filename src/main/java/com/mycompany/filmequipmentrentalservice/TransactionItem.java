/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.UUID;

/**
 *
 * @author bryanmulingbayan
 */
public class TransactionItem {
    UUID id;
    UUID transaction_id;
    int equipment_id;
    Double sub_total;
    Equipment equipment;

    public TransactionItem(UUID id, UUID transaction_id, int equipment_id, Double sub_total) {
        this.id = id;
        this.transaction_id = transaction_id;
        this.equipment_id = equipment_id;
        this.sub_total = sub_total;  
    }

    public void setSubTotal(Double sub_total) {
        this.sub_total = sub_total;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        this.equipment_id = equipment.id;
    }
}
