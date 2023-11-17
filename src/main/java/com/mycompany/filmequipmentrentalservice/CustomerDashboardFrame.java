/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.filmequipmentrentalservice;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Neil Patrick
 */
public class CustomerDashboardFrame extends javax.swing.JFrame {

    Cart cart = new Cart();

    /**
     * Creates new form dashboardFrame
     */
    public CustomerDashboardFrame() {
        initComponents();
        refreshEquipmentList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Right = new javax.swing.JPanel();
        HomeBUtton = new javax.swing.JButton();
        EquipmmentButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        allEquipmentScroolPane = new javax.swing.JScrollPane();
        EquipmentListTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        SearchTextFeild = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        endDatePicker = new com.toedter.calendar.JDateChooser();
        startDatePicker = new com.toedter.calendar.JDateChooser();
        myCartPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myCartTable = new javax.swing.JTable();
        removeAllButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Dashbard");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Right.setPreferredSize(new java.awt.Dimension(250, 680));

        HomeBUtton.setBackground(new java.awt.Color(255, 255, 255));
        HomeBUtton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        HomeBUtton.setForeground(new java.awt.Color(0, 102, 102));
        HomeBUtton.setText("Home");
        HomeBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBUttonActionPerformed(evt);
            }
        });

        EquipmmentButton.setBackground(new java.awt.Color(255, 255, 255));
        EquipmmentButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        EquipmmentButton.setForeground(new java.awt.Color(0, 102, 102));
        EquipmmentButton.setText("My Cart");
        EquipmmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipmmentButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Button");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setText("Button");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeBUtton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EquipmmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(HomeBUtton)
                .addGap(18, 18, 18)
                .addComponent(EquipmmentButton)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        getContentPane().add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Rent Equipment ");

        allEquipmentScroolPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        EquipmentListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Daily Fee", "Weekly Fee", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EquipmentListTable.setGridColor(new java.awt.Color(0, 102, 102));
        EquipmentListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipmentListTableMouseClicked(evt);
            }
        });
        allEquipmentScroolPane.setViewportView(EquipmentListTable);
        if (EquipmentListTable.getColumnModel().getColumnCount() > 0) {
            EquipmentListTable.getColumnModel().getColumn(0).setMinWidth(30);
            EquipmentListTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            EquipmentListTable.getColumnModel().getColumn(0).setMaxWidth(30);
            EquipmentListTable.getColumnModel().getColumn(2).setMinWidth(325);
            EquipmentListTable.getColumnModel().getColumn(2).setPreferredWidth(325);
            EquipmentListTable.getColumnModel().getColumn(2).setMaxWidth(325);
        }

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Search Equipent.");

        SearchTextFeild.setBackground(new java.awt.Color(255, 255, 255));
        SearchTextFeild.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTextFeild.setForeground(new java.awt.Color(0, 102, 102));
        SearchTextFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextFeildKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Start date");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("End date");

        endDatePicker.setBackground(new java.awt.Color(255, 255, 255));
        endDatePicker.setForeground(new java.awt.Color(0, 0, 0));

        startDatePicker.setBackground(new java.awt.Color(255, 255, 255));
        startDatePicker.setForeground(new java.awt.Color(0, 0, 0));
        startDatePicker.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startDatePickerPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(allEquipmentScroolPane, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel9)
                                .addGap(3, 3, 3)
                                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SearchTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(allEquipmentScroolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", jPanel2);

        myCartPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("My Cart");

        myCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipment Name", "Description", "Daily Fee", "Weekly Fee", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myCartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myCartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myCartTable);
        if (myCartTable.getColumnModel().getColumnCount() > 0) {
            myCartTable.getColumnModel().getColumn(0).setMinWidth(35);
            myCartTable.getColumnModel().getColumn(0).setPreferredWidth(35);
            myCartTable.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        removeAllButton.setBackground(new java.awt.Color(0, 102, 102));
        removeAllButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        removeAllButton.setLabel("Remove all");
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myCartPanelLayout = new javax.swing.GroupLayout(myCartPanel);
        myCartPanel.setLayout(myCartPanelLayout);
        myCartPanelLayout.setHorizontalGroup(
            myCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myCartPanelLayout.createSequentialGroup()
                .addGroup(myCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myCartPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(myCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                            .addGroup(myCartPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myCartPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        myCartPanelLayout.setVerticalGroup(
            myCartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myCartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeAllButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", myCartPanel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("REnt");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel3)
                .addContainerGap(535, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("My rent");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel4)
                .addContainerGap(540, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", jPanel4);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -30, 760, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshEquipmentList() {
        DefaultTableModel equipmentsTableModel = (DefaultTableModel) EquipmentListTable.getModel();
        List<Equipment> equipments = EquipmentService.getAllEquipments();
        equipmentsTableModel.setRowCount(0);

        System.out.println(equipments.size());

        for (int i = 0; i < equipments.size(); i++) {
            Equipment equipment = equipments.get(i);
            Object[] rowData = {equipment.id, equipment.name, equipment.description, equipment.daily_fee, equipment.weekly_fee, equipment.category.name};
            equipmentsTableModel.addRow(rowData);
        }

        EquipmentListTable.setRowSorter(null); // reset the table sort
        SearchTextFeild.setText(""); // reset search text feild

    }

    private void refreshCartList() {
        DefaultTableModel cartTableModel = (DefaultTableModel) myCartTable.getModel();
        cartTableModel.setRowCount(0);

        for (int i = 0; i < this.cart.equipments.size(); i++) {
            Equipment equipment = this.cart.equipments.get(i);
            Object[] rowData = {equipment.id, equipment.name, equipment.description, equipment.daily_fee, equipment.weekly_fee, equipment.category.name};
            cartTableModel.addRow(rowData);
        }

        EquipmentListTable.setRowSorter(null); // reset the table sort
        SearchTextFeild.setText(""); // reset search text feild

    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void HomeBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBUttonActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_HomeBUttonActionPerformed

    private void EquipmmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipmmentButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_EquipmmentButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SearchTextFeildKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFeildKeyPressed
        // TODO add your handling code here:
        DefaultTableModel obj = (DefaultTableModel) EquipmentListTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        EquipmentListTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(SearchTextFeild.getText()));

    }//GEN-LAST:event_SearchTextFeildKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refreshEquipmentList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EquipmentListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentListTableMouseClicked
        int i = EquipmentListTable.getSelectedRow();
        int id = (int) EquipmentListTable.getValueAt(i, 0);
        Equipment equipment = EquipmentService.getEquipmentById(id);

        if (!this.cart.equipments.contains(equipment)) {
            int response = JOptionPane.showConfirmDialog(this, "Do you want to add this?", "Select Option", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.cart.equipments.add(equipment);
                refreshCartList();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Already in  cart. ");
            }
        }
    }//GEN-LAST:event_EquipmentListTableMouseClicked

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Do you want to remove this?", "Select Option", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.cart.clearItems();
            refreshCartList();
        }
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void myCartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCartTableMouseClicked
        // TODO add your handling code here:
        int i = myCartTable.getSelectedRow();
        int response = JOptionPane.showConfirmDialog(this, "Do you want to remove this?", "Select Option", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.cart.removeItem(i);
            refreshCartList();
        }
    }//GEN-LAST:event_myCartTableMouseClicked

    private void startDatePickerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startDatePickerPropertyChange
        System.out.println(startDatePicker.getDate().toString());
    }//GEN-LAST:event_startDatePickerPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EquipmentListTable;
    private javax.swing.JButton EquipmmentButton;
    private javax.swing.JButton HomeBUtton;
    private javax.swing.JPanel Right;
    private javax.swing.JTextField SearchTextFeild;
    private javax.swing.JScrollPane allEquipmentScroolPane;
    private com.toedter.calendar.JDateChooser endDatePicker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel myCartPanel;
    private javax.swing.JTable myCartTable;
    private javax.swing.JButton removeAllButton;
    private com.toedter.calendar.JDateChooser startDatePicker;
    // End of variables declaration//GEN-END:variables
}
