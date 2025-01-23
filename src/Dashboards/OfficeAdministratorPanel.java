/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Dashboards;

import GarageSystemDatabase.GarageSystemDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class OfficeAdministratorPanel extends javax.swing.JPanel {

    /**
     * Creates new form OfficeAdministratorPanel
     */
    public OfficeAdministratorPanel(int userID) {
        initComponents();
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");  
        String dayName = LocalDate.now().format(formatter);  
        String quote = " ";
        
        try{
            Connection con = GarageSystemDatabase.Connect();

            String sql = "SELECT message_quotes.Quote FROM message_quotes " +
                 "JOIN message_days_of_the_week ON message_quotes.QuoteID = message_days_of_the_week.DayID " +
                 "WHERE message_days_of_the_week.Day = ?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dayName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                quote = rs.getString("Quote");
            }
            System.out.println(quote);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        setLayout(null);
        
        JLabel label = new JLabel(quote);
        label.setBounds(20, 20, 300, 30);
        add(label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
