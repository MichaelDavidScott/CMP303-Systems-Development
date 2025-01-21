/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GarageSystemDatabase;

import java.sql.*;
/**
 *
 * @author Michael David Scott
 */
public class DatabaseTest {
    public static void main(String[] args) {
        try{
            Connection c = GarageSystemDatabase.Connect();
            String sql = "SELECT * from user";
            
            PreparedStatement pS = c.prepareStatement(sql);
            
            ResultSet rS = pS.executeQuery();
            
            int count = 0;
         
            
while(rS.next()){
            System.out.println("id: " + rS.getString("id"));
            System.out.println("Username: " + rS.getString("username"));
            System.out.println("Password: " + rS.getString("password"));
            
            count++;
            
}
    System.out.println("==========");
    System.out.println("Total Number of users "+count);
        }catch(Exception e){
            
        }
        
    }
    
}
