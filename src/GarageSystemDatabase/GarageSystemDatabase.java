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
public class GarageSystemDatabase {
    public static Connection Connect(){
try{


Class.forName("org.sqlite.JDBC");
Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\NetBeansProjects\\CMP303 Systems Development\\garage_system.db");
return con;
}
catch(Exception e){
    System.out.print("Error: " + e);
    return null;
}

    }
    
}