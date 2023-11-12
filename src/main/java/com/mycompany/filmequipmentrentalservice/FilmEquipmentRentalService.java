/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.filmequipmentrentalservice;

import javax.swing.*;

/**
 *
 * @author Neil Patrick
 */
public class FilmEquipmentRentalService {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Film Equipment Rental Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new StartingPage()); // Add the Login panel to the frame
        frame.pack(); // Resize the frame to fit the components
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
