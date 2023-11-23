/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Neil Patrick
 */
public class Transaction {

    UUID id;
    Date startDate;
    Date endDate;
    int customer_id;
    String status;
    Double total;
    List<TransactionItem> items;
    Customer customer;

    public Transaction(UUID id, Date startDate, Date endDate, int customer_id, String status, Double total, List<TransactionItem> items) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer_id = customer_id;
        this.status = status;
        this.total = total;
        this.items = items;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(TransactionItem item) {
        this.items.add(item);
        this.total = this.computeTotal();
    }

    public void removeItem(int index) {
        this.items.remove(index);
        this.total = this.computeTotal();
    }

    public void clearItems() {
        this.items.clear();
        this.total = this.computeTotal();
    }

    public boolean isEquipmentAlreadyAdded(int equipmentId) {

        ArrayList<Integer> equipmentIds = new ArrayList<>();

        for (int i = 0; i < this.items.size(); i++) {
            equipmentIds.add(this.items.get(i).equipment_id);
        }

        return equipmentIds.contains(equipmentId);
    }

    public int getTotalNumberOfDays() {
        if (this.endDate != null && this.startDate != null) {
            return (int) ChronoUnit.DAYS.between(this.startDate.toInstant(), this.endDate.toInstant()) + 1;
        }

        return 0;
    }

    public int getNumberOfDays() {
        return this.getTotalNumberOfDays() % 7;
    }

    public int getNumberOfWeeks() {
        return this.getTotalNumberOfDays() / 7;
    }

    public String getDateRangeSummary() {
        int totalDays = this.getTotalNumberOfDays();
        int weeks = this.getNumberOfWeeks();
        int days = this.getNumberOfDays();

        String weekLabel = weeks > 1 ? "weeks" : "week";
        String dayLabel = days > 1 ? "days" : "day";

        if (totalDays == 0) {
            return "";
        }

        if (weeks > 0 && days > 0) {
            return String.valueOf(weeks) + " " + weekLabel + " and " + String.valueOf(days) + " " + dayLabel;
        }

        if (weeks > 0) {
            return String.valueOf(weeks) + " " + weekLabel;
        }

        return String.valueOf(days) + " " + dayLabel;
    }

    public Double computeTotal() {
        Double total = 0.0;

        for (int i = 0; i < this.items.size(); i++) {
            total = total + this.items.get(i).sub_total;
        }

        return total;
    }

}
