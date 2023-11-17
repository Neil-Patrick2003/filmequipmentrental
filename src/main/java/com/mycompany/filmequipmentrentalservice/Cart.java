/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bryanmulingbayan
 */
public class Cart {

    List<Equipment> equipments = new ArrayList<>();
    Date startDate;
    Date endDate;

    public void addItem(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public void clearItems() {
        this.equipments.clear();
    }

    public void removeItem(int index) {
        this.equipments.remove(index);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfDays() {
        if (this.endDate != null && this.startDate != null) {
            return (int) ChronoUnit.DAYS.between(this.startDate.toInstant(), this.endDate.toInstant());
        }

        return 0;
    }

}
