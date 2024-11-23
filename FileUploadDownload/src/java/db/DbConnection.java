/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.*;



public class DbConnection {
    public static Connection con;
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/fileupdown?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aa8112003#");
        }catch(SQLException ee){
            System.out.println(ee);
        }
        return con;
    }
    
}
